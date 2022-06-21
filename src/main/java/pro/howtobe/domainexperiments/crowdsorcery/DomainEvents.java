package pro.howtobe.domainexperiments.crowdsorcery;

import java.util.List;

public class DomainEvents {

    private final List<ProjectStarted> events;

    private DomainEvents(List<ProjectStarted> events) {
        this.events = events;
    }

    public boolean hasOccurred(ProjectStarted projectStarted) {
        return events.contains(projectStarted);
    }

    public static DomainEvents of(ProjectStarted... projectStarted) {
        return new DomainEvents(List.of(projectStarted));
    }

    public boolean noEventsOccurred() {
        return events.isEmpty();
    }

    public static DomainEvents empty() {
        return of();
    }
}
