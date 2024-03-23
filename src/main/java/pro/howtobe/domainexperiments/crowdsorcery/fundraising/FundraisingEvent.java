package pro.howtobe.domainexperiments.crowdsorcery.fundraising;

import org.joda.money.Money;
import pro.howtobe.domainexperiments.crowdsorcery.common.domain.DomainEvent;

public sealed interface FundraisingEvent extends DomainEvent {

    record ProjectIsFunded() implements FundraisingEvent {}

    record InvestmentMade(Money amount) implements FundraisingEvent {}

    record FundraisingHasStarted() implements FundraisingEvent {}

    record InvestmentRejected() implements FundraisingEvent {}
}
