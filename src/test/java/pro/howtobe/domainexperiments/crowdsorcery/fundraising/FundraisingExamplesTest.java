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
         given fundraising has started,
         when investment is made,
         then project is funded
        """
    )
    // @formatter:on
    @Test
    void projectIsFundedTest() {
        // given
        var fundraisingSystem = new SomeSystemIDontKnowHowToNameYet();
        var amount = Money.zero(CurrencyUnit.USD);
        var fundraisingHasStarted = fundraisingSystem.startFundraising();

        // when
        var projectIsFunded = fundraisingSystem.invest(amount);

        // then
        assertThat(projectIsFunded).isNotNull();
    }
}
