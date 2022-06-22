package pro.howtobe.domainexperiments.crowdsorcery.managingproject.domain;

public interface StartProjectCommandHandler {

    DomainEvents startProjectBy(Borrower borrower);
}
