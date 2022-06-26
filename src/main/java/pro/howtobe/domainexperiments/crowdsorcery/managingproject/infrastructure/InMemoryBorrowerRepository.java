package pro.howtobe.domainexperiments.crowdsorcery.managingproject.infrastructure;

import lombok.NonNull;
import pro.howtobe.domainexperiments.crowdsorcery.managingproject.domain.Borrower;
import pro.howtobe.domainexperiments.crowdsorcery.managingproject.domain.BorrowerRepository;

public class InMemoryBorrowerRepository implements BorrowerRepository {

    @Override
    public void save(@NonNull Borrower borrower) {

    }
}
