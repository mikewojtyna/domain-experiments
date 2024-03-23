package pro.howtobe.domainexperiments.crowdsorcery.fundraising;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Fundraising examples taken from Miro example mapping session https://miro.com/app/board/uXjVNhVgRkU=/")
class FundraisingExamplesTest {

    // @formatter:off
    @DisplayName(
        """
         project is funded
        """
    )
    // @formatter:on
    @Test
    void projectIsFundedTest() {
        // given
        var someSystemIDontKnowHowToNameYet = new SomeSystemIDontKnowHowToNameYet();

        // when
        var projectIsFunded = someSystemIDontKnowHowToNameYet.fundProject();

        // then
        assertThat(projectIsFunded).isNotNull();
    }
}
