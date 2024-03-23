package pro.howtobe.domainexperiments.crowdsorcery.fundraising;

import pro.howtobe.domainexperiments.crowdsorcery.common.domain.DomainEvent;

import java.util.List;

public record DomainEvents<E extends DomainEvent>(List<E> events) {

    public DomainEvents(List<E> events) {
        this.events = List.copyOf(events);
    }
}
