package pro.howtobe.domainexperiments.crowdsorcery.managingproject.domain;

import lombok.NonNull;

import java.time.Clock;
import java.time.LocalDate;
import java.util.UUID;

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
    public DomainResult<Borrower> register(RegistrationForm registrationForm) throws BorrowerRegistryException {
        if (criminalRecord.hasCriminalRecord(registrationForm.id())) {
            throw new BorrowerRegistryException(
                "Cannot register borrower based on register form %s. This person has criminal record.".formatted(
                    registrationForm));
        }
        var borrower = new Borrower(uniqueBorrowerId(), registrationForm.birthDate(), LocalDate.now(clock));
        return new DomainResult<>(borrower, DomainEvents.of(new BorrowerRegistered()));
    }

    private BorrowerId uniqueBorrowerId() {
        return new BorrowerId(UUID.randomUUID().toString());
    }
}
