package pro.howtobe.domainexperiments.crowdsorcery.fundraising;

import pro.howtobe.domainexperiments.crowdsorcery.managingproject.domain.Borrower;

public record ProjectProposal(FundraisingGoal goal, Borrower borrower, boolean hasStretchGoals) {
}
