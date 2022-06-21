package pro.howtobe.domainexperiments.crowdsorcery;

public class StartProjectCommandHandlerImpl implements StartProjectCommandHandler {

    @Override
    public DomainEvents startProjectBy(Borrower borrower) {
        return DomainEvents.of(new ProjectStarted());
    }
}
