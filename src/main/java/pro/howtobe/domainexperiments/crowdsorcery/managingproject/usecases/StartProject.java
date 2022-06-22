package pro.howtobe.domainexperiments.crowdsorcery.managingproject.usecases;

import pro.howtobe.domainexperiments.crowdsorcery.managingproject.domain.Borrower;
import pro.howtobe.domainexperiments.crowdsorcery.managingproject.domain.BorrowerId;
import pro.howtobe.domainexperiments.crowdsorcery.managingproject.domain.BorrowerRepository;
import pro.howtobe.domainexperiments.crowdsorcery.managingproject.domain.StartProjectCommandHandler;

import java.util.Optional;

public class StartProject {

    private final BorrowerRepository borrowerRepository;
    private final StartProjectCommandHandler startProjectCommandHandler;

    public StartProject(BorrowerRepository borrowerRepository,
                        StartProjectCommandHandler startProjectCommandHandler) {
        this.borrowerRepository = borrowerRepository;
        this.startProjectCommandHandler = startProjectCommandHandler;
    }

    public void startProject(BorrowerId borrowerId) {
        loadBorrower(borrowerId).ifPresent(startProjectCommandHandler::startProjectBy);
    }

    private Optional<Borrower> loadBorrower(BorrowerId borrowerId) {
        return borrowerRepository.findBy(borrowerId);
    }
}
