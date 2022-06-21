package pro.howtobe.domainexperiments.crowdsorcery;

public record Borrower(Age age) {

    public boolean isAdult() {
        return age().years() > 17;
    }
}
