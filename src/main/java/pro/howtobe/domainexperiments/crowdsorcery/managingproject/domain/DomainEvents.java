package pro.howtobe.domainexperiments.crowdsorcery.managingproject.domain;

import pro.howtobe.domainexperiments.crowdsorcery.common.domain.DomainEvent;

import java.util.List;

public class DomainEvents {

    private final List<DomainEvent> events;

    private DomainEvents(List<DomainEvent> events) {
        this.events = events;
    }

    public boolean hasOccurred(DomainEvent event) {
        return events.contains(event);
    }

    public static DomainEvents of(DomainEvent... events) {
        return new DomainEvents(List.of(events));
    }

    public boolean noEventsOccurred() {
        return events.isEmpty();
    }

    public static DomainEvents empty() {
        return of();
    }
}
