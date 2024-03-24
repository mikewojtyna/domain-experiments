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
         then project is funded
        """
    )
    // @formatter:on
    @Test
    void projectIsFundedTest() {
        // given
        var fundraisingSystem = new FundraisingSystem();
        var oneThousandUSD = Money.of(CurrencyUnit.USD, 1000);
        var fiveThousandUSD = Money.of(CurrencyUnit.USD, 5000);
        var fourThousandUSD = Money.of(CurrencyUnit.USD, 4000);
        var fundraisingGoal = new FundraisingGoal(Money.of(CurrencyUnit.USD, 10_000));
        fundraisingSystem.startFundraising(fundraisingGoal, Personas.borrowerNamed("George"));

        // when
        var eventsAfterInvestOneThousandUsd = fundraisingSystem.invest(oneThousandUSD);
        var eventsAfterInvestFiveThousandUsd = fundraisingSystem.invest(fiveThousandUSD);
        var eventsAfterInvestFourThousandUsd = fundraisingSystem.invest(fourThousandUSD);

        // then
        assertThat(eventsAfterInvestOneThousandUsd.events()).hasSize(2)
                                                            .satisfiesExactly(
                                                                event -> assertThat(event).isInstanceOf(
                                                                    FundraisingEvent.FundraisingHasStarted.class),
                                                                event -> assertThat(event).isInstanceOf(
                                                                    FundraisingEvent.InvestmentMade.class));
        assertThat(eventsAfterInvestFiveThousandUsd.events()).hasSize(3)
                                                             .satisfiesExactly(
                                                                 event -> assertThat(event).isInstanceOf(
                                                                     FundraisingEvent.FundraisingHasStarted.class),
                                                                 event -> assertThat(event).isInstanceOf(
                                                                     FundraisingEvent.InvestmentMade.class),
                                                                 event -> assertThat(event).isInstanceOf(
                                                                     FundraisingEvent.InvestmentMade.class));
        assertThat(eventsAfterInvestFourThousandUsd.events()).hasSize(5)
                                                             .satisfiesExactly(
                                                                 event -> assertThat(event).isInstanceOf(
                                                                     FundraisingEvent.FundraisingHasStarted.class),
                                                                 firstEvent -> assertThat(firstEvent).isInstanceOf(
                                                                     FundraisingEvent.InvestmentMade.class),
                                                                 secondEvent -> assertThat(secondEvent).isInstanceOf(
                                                                     FundraisingEvent.InvestmentMade.class),
                                                                 thirdEvent -> assertThat(thirdEvent).isInstanceOf(
                                                                     FundraisingEvent.InvestmentMade.class),
                                                                 fourthEvent -> assertThat(fourthEvent).isInstanceOf(
                                                                     FundraisingEvent.ProjectFunded.class));
    }

    // @formatter:off
    @DisplayName(
        """
         given project has been funded,
         then funds are released to the borrower
        """
    )
    // @formatter:on
    @Test
    void releaseFundsTest() {
        // given
        var projectFunded = new FundraisingEvent.ProjectFunded(Personas.borrowerNamed("George"));
        var fundsReleaser = new FundsReleaser();

        // when
        var fundsReleased = fundsReleaser.when(projectFunded);

        // then
        assertThat(fundsReleased.toBorrower()).isEqualTo(projectFunded.borrower());
    }
}
