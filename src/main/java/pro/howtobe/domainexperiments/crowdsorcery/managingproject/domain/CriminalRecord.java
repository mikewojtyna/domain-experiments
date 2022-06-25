package pro.howtobe.domainexperiments.crowdsorcery.managingproject.domain;

import lombok.NonNull;

public interface CriminalRecord {

    boolean hasCriminalRecord(@NonNull PersonalId personalId) throws CriminalRecordException;
}
