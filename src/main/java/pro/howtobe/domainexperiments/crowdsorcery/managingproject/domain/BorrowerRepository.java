package pro.howtobe.domainexperiments.crowdsorcery.managingproject.domain;

import lombok.NonNull;

public interface BorrowerRepository {

    void save(@NonNull Borrower borrower);
}
