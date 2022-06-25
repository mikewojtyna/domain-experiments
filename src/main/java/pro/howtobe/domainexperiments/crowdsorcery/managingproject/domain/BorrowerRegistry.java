package pro.howtobe.domainexperiments.crowdsorcery.managingproject.domain;

import lombok.NonNull;

public interface BorrowerRegistry {

    DomainResult<Borrower> register(@NonNull RegistrationForm registerForm) throws BorrowerRegistryException;
}
