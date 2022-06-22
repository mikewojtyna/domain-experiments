package pro.howtobe.domainexperiments.crowdsorcery.fundingproject.domain;

import org.joda.money.Money;
import pro.howtobe.domainexperiments.crowdsorcery.managingproject.domain.DomainEvents;

public class InvestorAccount {

    public void makeDeposit() {
        throw new UnsupportedOperationException("Implement this method");
    }

    public void withdraw(Money amount) {
        throw new UnsupportedOperationException("Implement this method");
    }

    public DomainEvents investInto(Money amount, Project project) {
        return DomainEvents.of(new FundsInvested());
    }
}
