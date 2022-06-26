package pro.howtobe.domainexperiments.crowdsorcery.managingproject.domain;

import lombok.NonNull;
import org.joda.money.Money;

public record ProjectProposal(@NonNull Money totalValue) {
}
