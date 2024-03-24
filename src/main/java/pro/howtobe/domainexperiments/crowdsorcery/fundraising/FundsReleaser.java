package pro.howtobe.domainexperiments.crowdsorcery.fundraising;

public class FundsReleaser {

    public FundsReleasedToTheBorrower when(FundraisingEvent.ProjectFunded projectFunded) {
        return new FundsReleasedToTheBorrower(projectFunded.borrower());
    }
}
