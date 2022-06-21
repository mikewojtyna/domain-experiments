package pro.howtobe.domainexperiments.crowdsorcery;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Examples from Miro [example-mapping/CrowdSorcery-example-mapping-v0.pdf]")
class ExampleMappingTest {

    @DisplayName("Starting a project")
    @Nested
    class StartingAProject {

        private Borrower borrower;

        // @formatter:off
        @DisplayName(
            """
             given adult borrower,
             when borrower wants to start a project,
             then project is started successfully
            """	
        )
        // @formatter:on
        @Test
        void adultTest() {
            // given
            borrower = anyAdultBorrower();

            // when
            var events = borrowerWantsToStartAProject();

            // then
            assertThat(events.hasOccurred(anyProjectStartedEvent())).isTrue();
        }

        // @formatter:off
        @DisplayName(
            """
             given borrower who is 17yo,
             when borrower wants to start a project,
             then project is not started
            """
        )
        // @formatter:on
        @Test
        void seventeenYoTest() {
            // given
            borrower = borrowerOfAge(17);

            // when
            var events = borrowerWantsToStartAProject();

            // then
            assertThat(events.noEventsOccurred()).isTrue();
        }

        private Borrower borrowerOfAge(int years) {
            return new Borrower(new Age(years));
        }

        private ProjectStarted anyProjectStartedEvent() {
            return new ProjectStarted();
        }

        private DomainEvents borrowerWantsToStartAProject() {
            var commandHandler = new StartProjectCommandHandlerImpl();
            return commandHandler.startProjectBy(borrower);
        }

        private Borrower anyAdultBorrower() {
            return new Borrower(new Age(20));
        }
    }
}
