package pro.howtobe.domainexperiments.crowdsorcery.fundraising;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pro.howtobe.domainexperiments.crowdsorcery.managingproject.domain.DomainEvents;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Project fundraising according to https://miro.com/app/board/uXjVPvC5ORk=/")
class ProjectFundraisingTest {

    // @formatter:off
    @DisplayName(
        """
         investor invests into a project
        """	
    )
    // @formatter:on
    @Test
    void test() {
        // given
        FundraisingSystem fundraisingSystem = null;

        // when
        DomainEvents events = fundraisingSystem.investIntoProject();

        // then
        assertThat(events.hasOccurredAnyEventOfType(InvestedIntoProject.class)).isTrue();
    }
}
