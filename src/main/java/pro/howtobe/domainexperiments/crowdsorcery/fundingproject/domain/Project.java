package pro.howtobe.domainexperiments.crowdsorcery.fundingproject.domain;

import org.joda.money.Money;
import pro.howtobe.domainexperiments.crowdsorcery.fundraising.Investor;
import pro.howtobe.domainexperiments.crowdsorcery.managingproject.domain.DomainEvents;

import java.time.LocalDate;

public record Project() {

    public static Project ofFundraisingTimeGoal(LocalDate of) {
        return null;
    }

    public DomainEvents invest(Money amount, Investor george) {

        return null;
    }
}
