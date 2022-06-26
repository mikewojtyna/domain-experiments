package pro.howtobe.domainexperiments.crowdsorcery.managingproject.infrastructure;

import pro.howtobe.domainexperiments.crowdsorcery.managingproject.domain.CrowdSorceryException;

public class BorrowerDocumentsException extends CrowdSorceryException {

    public BorrowerDocumentsException(String message) {
        super(message);
    }

    public BorrowerDocumentsException(String message, Throwable cause) {
        super(message, cause);
    }
}
