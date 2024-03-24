package pro.howtobe.domainexperiments.crowdsorcery.fundraising;

import org.joda.money.Money;
import pro.howtobe.domainexperiments.crowdsorcery.common.domain.DomainEvent;
import pro.howtobe.domainexperiments.crowdsorcery.managingproject.domain.Borrower;

public sealed interface FundraisingEvent extends DomainEvent {

    record ProjectFunded(Borrower borrower) implements FundraisingEvent {}

    record InvestmentMade(Money amount) implements FundraisingEvent {}

    record FundraisingHasStarted() implements FundraisingEvent {}

    record InvestmentRejected() implements FundraisingEvent {}
}
