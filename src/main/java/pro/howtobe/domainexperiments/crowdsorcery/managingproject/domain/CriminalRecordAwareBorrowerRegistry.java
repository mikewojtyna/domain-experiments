package pro.howtobe.domainexperiments.crowdsorcery.managingproject.domain;

import lombok.NonNull;

import java.time.Clock;
import java.time.LocalDate;

public class CriminalRecordAwareBorrowerRegistry implements BorrowerRegistry {

    @NonNull
    private final Clock clock;
    @NonNull
    private final CriminalRecord criminalRecord;

    public CriminalRecordAwareBorrowerRegistry(@NonNull Clock clock,
                                               @NonNull CriminalRecord criminalRecord) {
        this.clock = clock;
        this.criminalRecord = criminalRecord;
    }

    @Override
    public DomainResult<Borrower> register(RegistrationForm registerForm) throws BorrowerRegistryException {
        if (criminalRecord.hasCriminalRecord(registerForm.id())) {
            throw new BorrowerRegistryException(
                "Cannot register borrower based on register form %s. This person has criminal record.".formatted(
                    registerForm));
        }
        return new DomainResult<>(new Borrower(registerForm.birthDate(), LocalDate.now(clock)),
                                  DomainEvents.of(new BorrowerRegistered()));
    }
}
