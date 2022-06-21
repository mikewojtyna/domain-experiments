package pro.howtobe.domainexperiments.crowdsorcery;

public interface StartProjectCommandHandler {

    DomainEvents startProjectBy(Borrower borrower);
}
