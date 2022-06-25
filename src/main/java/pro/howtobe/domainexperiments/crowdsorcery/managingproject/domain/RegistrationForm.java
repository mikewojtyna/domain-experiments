package pro.howtobe.domainexperiments.crowdsorcery.managingproject.domain;

import lombok.NonNull;

import java.time.LocalDate;

public record RegistrationForm(@NonNull LocalDate birthDate, @NonNull PersonalId id) {}
