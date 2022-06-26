package pro.howtobe.domainexperiments.crowdsorcery.managingproject.domain;

import lombok.NonNull;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

public class ProjectProposalSupervisor {

    private static final Money WORTH_ACCEPTABLE_THRESHOLD_IN_USD = Money.of(CurrencyUnit.USD, 10_000);

    public DomainEvents startProject(@NonNull ProjectProposal projectProposal) throws ProjectProposalSupervisorException {
        if (isTotalValueAcceptable(projectProposal)) {
            return DomainEvents.of(new ProjectStarted());
        }
        else {
            return DomainEvents.of(new ProjectRequestAcceptedForVerification());
        }
    }

    private boolean isTotalValueAcceptable(ProjectProposal project) {
        return project.totalValue().isLessThan(WORTH_ACCEPTABLE_THRESHOLD_IN_USD);
    }
}
