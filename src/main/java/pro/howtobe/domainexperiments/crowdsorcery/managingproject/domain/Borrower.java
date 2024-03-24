package pro.howtobe.domainexperiments.crowdsorcery.managingproject.domain;

import lombok.NonNull;
import lombok.Value;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.Period;

@Value
@Accessors(fluent = true)
public class Borrower {

    @NonNull
    LocalDate birthDate;
    @NonNull
    BorrowerId id;

    public Borrower(@NonNull BorrowerId id,
             @NonNull LocalDate birthDate,
             @NonNull LocalDate now) throws IllegalArgumentException {
        var years = Period.between(birthDate, now).getYears();
        if (years < 18) {
            throw new IllegalArgumentException("Borrower must be adult, but is %s years old.".formatted(years));
        }
        this.id = id;
        this.birthDate = birthDate;
    }
}
