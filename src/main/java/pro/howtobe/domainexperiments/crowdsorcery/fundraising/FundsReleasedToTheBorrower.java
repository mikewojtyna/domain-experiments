package pro.howtobe.domainexperiments.crowdsorcery.fundraising;

import pro.howtobe.domainexperiments.crowdsorcery.common.domain.DomainEvent;
import pro.howtobe.domainexperiments.crowdsorcery.managingproject.domain.Borrower;

public record FundsReleasedToTheBorrower(Borrower toBorrower) implements DomainEvent {
}
