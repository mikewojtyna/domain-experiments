package pro.howtobe.domainexperiments.crowdsorcery.fundingproject.domain.experiment;

import org.joda.money.Money;
import pro.howtobe.domainexperiments.crowdsorcery.managingproject.domain.DomainEvents;

public class InvestorAccountExperiment {

    public DomainEvents investInto(Money of, GroupsOfAssetsSpecification groupsOfAssetsSpecification) {
        return DomainEvents.empty();
    }
}
