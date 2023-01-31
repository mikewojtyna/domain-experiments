package pro.howtobe.domainexperiments.crowdsorcery.fundraising;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pro.howtobe.domainexperiments.crowdsorcery.fundingproject.domain.Project;
import pro.howtobe.domainexperiments.crowdsorcery.managingproject.domain.DomainEvents;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Project fundraising according to https://miro.com/app/board/uXjVPvC5ORk=/")
class ProjectFundraisingTest {

    // @formatter:off
    @DisplayName(
        """
         fundraising time goal exceeded
        """
    )
    // @formatter:on
    @Test
    void test() {
        // given
        Project project = Project.ofFundraisingTimeGoal(LocalDate.of(2023, 1, 26));
        Money amount = Money.of(CurrencyUnit.USD, 100);

        // when
        DomainEvents events = project.invest(amount, george);

        // time
        assertThat(events.hasOccurredAnyEventOfType(InvestmentRejected.class)).isTrue();
    }

    // @formatter:off
    @DisplayName(
        """
         given investment of $100 USD is made and George (the investor) has only $50 in his deposit,
         then investment is forbidden
        """
    )
    // @formatter:on
    @Test
    void test2() {
        // given
        Project project = Project.ofFundraisingTimeGoal(LocalDate.of(2023, 1, 26));
        Money amount = Money.of(CurrencyUnit.USD, 100);
        Deposit deposit = new Deposit(Money.of(CurrencyUnit.USD, 50));
        Investor george = new Investor(deposit);

        // when
        DomainEvents events = project.invest(amount, george);

        // time
        assertThat(events.hasOccurredAnyEventOfType(InvestmentForbidden.class)).isTrue();
    }
}
