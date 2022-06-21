package pro.howtobe.domainexperiments.crowdsorcery;

import java.time.Clock;
import java.time.LocalDate;

public class StartProjectCommandHandlerImpl implements StartProjectCommandHandler {

    private final Clock clock;

    public StartProjectCommandHandlerImpl(Clock clock) {
        this.clock = clock;
    }

    @Override
    public DomainEvents startProjectBy(Borrower borrower) {
        if (canAccept(borrower)) {
            return DomainEvents.of(new ProjectStarted());
        }
        return DomainEvents.empty();
    }

    private boolean canAccept(Borrower borrower) {
        return borrower.isAdult(LocalDate.now(clock));
    }
}
