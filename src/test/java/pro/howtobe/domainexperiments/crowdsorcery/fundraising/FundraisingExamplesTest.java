package pro.howtobe.domainexperiments.crowdsorcery.fundraising;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Fundraising examples taken from Miro example mapping session https://miro.com/app/board/uXjVNhVgRkU=/")
class FundraisingExamplesTest {

    // @formatter:off
    @DisplayName(
        """
         given fundraising of project with fundraising goal of $10000 has started,
         when investments of $1000, $5000 and $4000 are made,
         then project is funded and funds are released to the borrower
        """
    )
    // @formatter:on
    @Test
    void projectIsFundedTest() {
        // given
        var fundraisingSystem = new SomeSystemIDontKnowHowToNameYet();
        var oneThousandUSD = Money.of(CurrencyUnit.USD, 1000);
        var fiveThousandUSD = Money.of(CurrencyUnit.USD, 5000);
        var fourThousandUSD = Money.of(CurrencyUnit.USD, 4000);
        var fundraisingHasStarted = fundraisingSystem.startFundraising();

        // when
        var eventAfterInvestOneThousandUsd = fundraisingSystem.invest(oneThousandUSD);
        var eventAfterInvestFiveThousandUsd = fundraisingSystem.invest(fiveThousandUSD);
        var eventAfterInvestFourThousandUsd = fundraisingSystem.invest(fourThousandUSD);

        // then
        assertThat(eventAfterInvestOneThousandUsd).isNull();
        assertThat(eventAfterInvestFiveThousandUsd).isNull();
        assertThat(eventAfterInvestFourThousandUsd).isNotNull();
    }
}
