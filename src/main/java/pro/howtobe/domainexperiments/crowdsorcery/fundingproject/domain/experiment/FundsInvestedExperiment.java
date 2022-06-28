package pro.howtobe.domainexperiments.crowdsorcery.fundingproject.domain.experiment;

import org.joda.money.Money;
import pro.howtobe.domainexperiments.crowdsorcery.common.domain.DomainEvent;

public record FundsInvestedExperiment(Money amount, GroupsOfAssetsSpecification specification) implements DomainEvent {
}
