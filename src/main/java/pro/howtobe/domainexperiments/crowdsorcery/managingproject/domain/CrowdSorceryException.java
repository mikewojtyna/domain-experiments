package pro.howtobe.domainexperiments.crowdsorcery.managingproject.domain;

public class CrowdSorceryException extends RuntimeException {

    public CrowdSorceryException(String message) {
        super(message);
    }

    public CrowdSorceryException(String message, Throwable cause) {
        super(message, cause);
    }
}
