package pro.howtobe.domainexperiments.crowdsorcery;

import lombok.Value;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.Period;

@Value
@Accessors(fluent = true)
public class Borrower {

    LocalDate birthDate;

    public Borrower(LocalDate birthDate, LocalDate now) throws IllegalArgumentException {
        var years = Period.between(birthDate, now).getYears();
        if (years < 18) {
            throw new IllegalArgumentException("Borrower must be adult, but is %s years old.".formatted(years));
        }
        this.birthDate = birthDate;
    }
}
