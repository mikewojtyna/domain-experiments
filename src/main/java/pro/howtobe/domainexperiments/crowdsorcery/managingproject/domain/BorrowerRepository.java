package pro.howtobe.domainexperiments.crowdsorcery.managingproject.domain;

import java.util.Optional;

public interface BorrowerRepository {

    Optional<Borrower> findBy(BorrowerId borrowerId);
}
