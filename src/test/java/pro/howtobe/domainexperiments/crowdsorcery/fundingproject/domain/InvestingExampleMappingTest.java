package pro.howtobe.domainexperiments.crowdsorcery.fundingproject.domain;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Investing into projects example mapping")
class InvestingExampleMappingTest {

    // @formatter:off
    @DisplayName(
        """
         Investor can invest into any project
        """
    )
    // @formatter:on
    @Test
    void investAnyProjectTest() {
        // given
        var investorAccount = new InvestorAccount();
        var anyProject = new Project();

        // when
        var events = investorAccount.investInto(Money.of(CurrencyUnit.EUR, 100), anyProject);

        // then
        var expectedFundsInvestedEvent = new FundsInvested();
        assertThat(events.hasOccurred(expectedFundsInvestedEvent)).isTrue();
    }
}
