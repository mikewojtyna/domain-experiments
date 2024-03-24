package pro.howtobe.domainexperiments.crowdsorcery.fundraising;

import pro.howtobe.domainexperiments.crowdsorcery.managingproject.domain.Borrower;
import pro.howtobe.domainexperiments.crowdsorcery.managingproject.domain.BorrowerId;

import java.time.LocalDate;
import java.util.UUID;

public class Personas {

    public static Borrower borrowerNamed(String name) {
        return new Borrower(new BorrowerId(UUID.randomUUID().toString()), LocalDate.now(), LocalDate.now().plusYears(20));
    }
}
