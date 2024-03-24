package pro.howtobe.domainexperiments.crowdsorcery.fundraising;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import pro.howtobe.domainexperiments.crowdsorcery.managingproject.domain.Borrower;

import java.util.ArrayList;
import java.util.List;

public class FundraisingSystem {

    private final List<FundraisingEvent> events = new ArrayList<>(List.of());
    private FundraisingGoal goal;
    private Borrower borrower;
    private boolean funded;
    private boolean hasStretchGoals;

    public DomainEvents<FundraisingEvent> invest(Money amount) {
        if (events.stream().findFirst().stream().anyMatch(FundraisingEvent.FundraisingHasStarted.class::isInstance)) {
            if (goalIsReached() && !hasStretchGoals) {
                events.add(new FundraisingEvent.InvestmentRejected());
            }
            else {
                events.add(new FundraisingEvent.InvestmentMade(amount));
                if (!funded && goalIsReached()) {
                    events.add(new FundraisingEvent.ProjectFunded(borrower));
                    funded = true;
                }
            }
        }
        else {
            events.add(new FundraisingEvent.InvestmentRejected());
        }
        return new DomainEvents<>(events);
    }

    private boolean goalIsReached() {
        return !events.stream()
                      .filter(FundraisingEvent.InvestmentMade.class::isInstance)
                      .map(FundraisingEvent.InvestmentMade.class::cast)
                      .map(FundraisingEvent.InvestmentMade::amount).reduce(Money::plus)
                      .orElse(Money.zero(CurrencyUnit.USD))
                      .isLessThan(goal.money());
    }

    public DomainEvents<FundraisingEvent> startFundraising(ProjectProposal projectProposal) {
        events.add(new FundraisingEvent.FundraisingHasStarted());
        this.goal = projectProposal.goal();
        this.borrower = projectProposal.borrower();
        this.hasStretchGoals = projectProposal.hasStretchGoals();
        return new DomainEvents<>(events);
    }
}
