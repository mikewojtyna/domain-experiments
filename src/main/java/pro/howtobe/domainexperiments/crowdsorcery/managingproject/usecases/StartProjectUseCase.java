package pro.howtobe.domainexperiments.crowdsorcery.managingproject.usecases;

import lombok.NonNull;
import pro.howtobe.domainexperiments.crowdsorcery.managingproject.domain.ProjectProposal;
import pro.howtobe.domainexperiments.crowdsorcery.managingproject.domain.ProjectProposalSupervisor;

public class StartProjectUseCase {

    @NonNull
    private final ProjectProposalSupervisor projectProposalSupervisor;

    public StartProjectUseCase(@NonNull ProjectProposalSupervisor projectProposalSupervisor) {
        this.projectProposalSupervisor = projectProposalSupervisor;
    }

    public void startProject(ProjectProposal projectProposal) {
        projectProposalSupervisor.startProject(projectProposal);
    }
}
