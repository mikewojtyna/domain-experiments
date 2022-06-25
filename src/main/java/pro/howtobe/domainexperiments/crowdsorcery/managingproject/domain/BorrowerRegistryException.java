package pro.howtobe.domainexperiments.crowdsorcery.managingproject.domain;

public class BorrowerRegistryException extends CrowdSorceryException {

    public BorrowerRegistryException(String message) {
        super(message);
    }

    public BorrowerRegistryException(String message, Throwable cause) {
        super(message, cause);
    }
}
