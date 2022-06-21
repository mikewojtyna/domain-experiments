package pro.howtobe.domainexperiments.crowdsorcery;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Clock;
import java.time.LocalDate;
import java.time.ZoneOffset;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Examples from Miro [example-mapping/CrowdSorcery-example-mapping-v0.pdf]")
class ExampleMappingTest {

    @DisplayName("Starting a project")
    @Nested
    class StartingAProject {

        private Borrower borrower;
        private LocalDate currentDate;
        private StartProjectCommandHandler commandHandler;

        @BeforeEach
        void setup() {
            currentDate = LocalDate.EPOCH;
            commandHandler = new StartProjectCommandHandlerImpl(Clock.fixed(currentDate.atStartOfDay()
                                                                                       .toInstant(ZoneOffset.UTC),
                                                                            ZoneOffset.UTC));
        }

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
             given borrower who is younger than 18 years old,
             when borrower wants to start a project,
             then project is not started
            """
        )
        // @formatter:on
        @ParameterizedTest(name = "given borrower is {0} years old.")
        @ValueSource(ints = {17, 16, 8, 4, 2, 1})
        void tooYoungTest(int years) {
            // given
            borrower = borrowerOfAge(years);

            // when
            var events = borrowerWantsToStartAProject();

            // then
            assertThat(events.noEventsOccurred()).isTrue();
        }

        private Borrower borrowerOfAge(int years) {
            return new Borrower(currentDate.minusYears(years));
        }

        private ProjectStarted anyProjectStartedEvent() {
            return new ProjectStarted();
        }

        private DomainEvents borrowerWantsToStartAProject() {
            return commandHandler.startProjectBy(borrower);
        }

        private Borrower anyAdultBorrower() {
            return new Borrower(currentDate.minusYears(20));
        }
    }
}
