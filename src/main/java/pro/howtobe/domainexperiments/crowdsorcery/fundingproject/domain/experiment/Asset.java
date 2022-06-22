package pro.howtobe.domainexperiments.crowdsorcery.fundingproject.domain.experiment;

public record Asset(String name) {

    public static Asset realEstate() {
        return new Asset("real estate asset");
    }
}
