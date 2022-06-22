package pro.howtobe.domainexperiments.crowdsorcery.managingproject.adapters.secondary;

import pro.howtobe.domainexperiments.crowdsorcery.managingproject.domain.Borrower;
import pro.howtobe.domainexperiments.crowdsorcery.managingproject.domain.BorrowerId;
import pro.howtobe.domainexperiments.crowdsorcery.managingproject.domain.BorrowerRepository;

import java.util.Optional;

public class InMemoryBorrowerRepository implements BorrowerRepository {

    @Override
    public Optional<Borrower> findBy(BorrowerId borrowerId) {
        return Optional.empty();
    }
}
