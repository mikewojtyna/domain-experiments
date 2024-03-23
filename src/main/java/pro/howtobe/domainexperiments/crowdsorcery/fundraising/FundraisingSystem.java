package pro.howtobe.domainexperiments.crowdsorcery.fundraising;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.util.ArrayList;
import java.util.List;

public class FundraisingSystem {

    private List<FundraisingEvent> events = new ArrayList<>(List.of());
    private FundraisingGoal goal;

    public DomainEvents<FundraisingEvent> invest(Money amount) {
        if (events.stream().findFirst().stream().anyMatch(FundraisingEvent.FundraisingHasStarted.class::isInstance)) {
            events.add(new FundraisingEvent.InvestmentMade(amount));
            if (goalIsReached()) {
                events.add(new FundraisingEvent.ProjectIsFunded());
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

    public DomainEvents<FundraisingEvent> startFundraising(FundraisingGoal goal) {
        events.add(new FundraisingEvent.FundraisingHasStarted());
        this.goal = goal;
        return new DomainEvents<>(events);
    }
}
