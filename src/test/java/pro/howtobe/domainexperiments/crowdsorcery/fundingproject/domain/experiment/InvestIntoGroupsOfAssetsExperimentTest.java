package pro.howtobe.domainexperiments.crowdsorcery.fundingproject.domain.experiment;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("Experiment #0: investors can now invest only in groups of assets instead of individual projects")
class InvestIntoGroupsOfAssetsExperimentTest {

    // @formatter:off
    @DisplayName(
        """
         Investor can invest into groups of assets according to the investment strategy to minimize the risk
        """
    )
    // @formatter:on
    @Test
    void investIntoGroupsOfAssetsTest() {
        // given
        var investorAccount = new InvestorAccountExperiment();
        var groupsOfAssetsSpecification =
            GroupsOfAssetsSpecification.investInto(Asset.realEstate())
                                       .atLeast(Money.of(CurrencyUnit.EUR, 10))
                                       .atMost(Money.of(CurrencyUnit.EUR, 25));
        var funds = Money.of(CurrencyUnit.EUR, 100);

        // when
        var events = investorAccount.investInto(funds, groupsOfAssetsSpecification);

        // then
        var expectedFundsInvestedIntoGroupOfAssets = new FundsInvestedExperiment(funds, groupsOfAssetsSpecification);
        assertThat(events.hasOccurred(expectedFundsInvestedIntoGroupOfAssets)).isTrue();
    }
}
