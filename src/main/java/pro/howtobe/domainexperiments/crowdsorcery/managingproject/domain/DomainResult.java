package pro.howtobe.domainexperiments.crowdsorcery.managingproject.domain;

import lombok.NonNull;

public record DomainResult<RESULT>(@NonNull RESULT result, @NonNull DomainEvents events) {
}
