package pro.howtobe.domainexperiments.crowdsorcery.managingproject.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowableOfType;

@DisplayName("Examples from Miro example-mapping/CrowdSorcery-example-mapping-v1.png")
class ExampleMappingTest {

    @DisplayName("Starting a project")
    @Nested
    class StartingAProject {

        private Borrower borrower;
        private StartProjectCommandHandler commandHandler;

        @BeforeEach
        void setup() {
            commandHandler = new StartProjectCommandHandlerImpl();
        }

        // @formatter:off
        @DisplayName(
            """
             given borrower,
             when borrower wants to start a project,
             then project is started successfully
            """	
        )
        // @formatter:on
        @Test
        void startTest() {
            // given
            borrower = anyBorrower();

            // when
            var events = borrowerWantsToStartAProject();

            // then
            assertThat(events.hasOccurred(anyProjectStartedEvent())).isTrue();
        }

        private Borrower anyBorrower() {
            return new Borrower(LocalDate.of(2004, 6, 10), LocalDate.of(2022, 6, 10));
        }

        private ProjectStarted anyProjectStartedEvent() {
            return new ProjectStarted();
        }

        private DomainEvents borrowerWantsToStartAProject() {
            return commandHandler.startProjectBy(borrower);
        }
    }

    @DisplayName("New borrower registers")
    @Nested
    class NewBorrowerRegisters {

        // @formatter:off
        @DisplayName(
            """
             Only adult borrowers can register their accounts
            """
        )
        // @formatter:on
        @ParameterizedTest(name = "given birth date {0} and current date {1}, then this borrower can register her account")
        @CsvSource({
            "2004-06-10, 2022-06-10",
            "2003-06-10, 2022-06-10",
            "1995-06-10, 2022-06-10",
            "1990-06-10, 2022-06-10",
            "1980-06-10, 2022-06-10"
        })
        void canRegisterBorrowerTest(LocalDate birthDate, LocalDate now) {
            new Borrower(birthDate, now);
        }

        // @formatter:off
        @DisplayName(
            """
             Borrowers younger than 18 years old cannot register their accounts
            """
        )
        // @formatter:on
        @ParameterizedTest(name = "given birth date {0} and current date {1}, then this borrower is not allowed to register her account")
        @CsvSource({
            "2005-06-10, 2022-06-10",
            "2006-06-10, 2022-06-10",
            "2015-06-10, 2022-06-10",
            "2022-06-10, 2022-06-10",
            "2022-06-10, 2022-06-10"
        })
        void borrowerTest(LocalDate birthDate, LocalDate now) {
            var exception = catchThrowableOfType(() -> new Borrower(birthDate, now), IllegalArgumentException.class);
            assertThat(exception).isNotNull();
        }
    }
}
