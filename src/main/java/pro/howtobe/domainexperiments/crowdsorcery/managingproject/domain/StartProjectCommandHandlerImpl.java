package pro.howtobe.domainexperiments.crowdsorcery.managingproject.domain;

public class StartProjectCommandHandlerImpl implements StartProjectCommandHandler {

    @Override
    public DomainEvents startProjectBy(Borrower borrower) {
        if (canAccept()) {
            return DomainEvents.of(new ProjectStarted());
        }
        return DomainEvents.empty();
    }

    private boolean canAccept() {
        return true;
    }
}