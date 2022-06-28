package pro.howtobe.domainexperiments.crowdsorcery.fundingproject.domain.experiment;

import org.joda.money.Money;

public class GroupsOfAssetsSpecification {

    public static FundsStep investInto(Asset asset) {
        return new FundsStep();
    }

    public static class FundsStep {

        public FundsStep atLeast(Money money) {
            return this;
        }

        public GroupsOfAssetsSpecification atMost(Money money) {
            return new GroupsOfAssetsSpecification();
        }
    }
}
