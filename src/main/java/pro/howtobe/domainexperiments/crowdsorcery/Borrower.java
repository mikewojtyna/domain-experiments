package pro.howtobe.domainexperiments.crowdsorcery;

import java.time.LocalDate;
import java.time.Period;

public record Borrower(LocalDate birthDate) {

    public boolean isAdult(LocalDate now) {
        return Period.between(birthDate(), now).getYears() > 17;
    }
}
