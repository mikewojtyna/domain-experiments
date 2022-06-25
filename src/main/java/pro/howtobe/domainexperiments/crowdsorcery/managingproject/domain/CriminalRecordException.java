package pro.howtobe.domainexperiments.crowdsorcery.managingproject.domain;

public class CriminalRecordException extends CrowdSorceryException {

    public CriminalRecordException(String message) {
        super(message);
    }

    public CriminalRecordException(String message, Throwable cause) {
        super(message, cause);
    }
}
