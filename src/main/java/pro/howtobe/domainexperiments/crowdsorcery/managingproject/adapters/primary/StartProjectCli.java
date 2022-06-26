package pro.howtobe.domainexperiments.crowdsorcery.managingproject.adapters.primary;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import pro.howtobe.domainexperiments.crowdsorcery.managingproject.domain.BorrowerId;
import pro.howtobe.domainexperiments.crowdsorcery.managingproject.domain.ProjectProposal;
import pro.howtobe.domainexperiments.crowdsorcery.managingproject.usecases.StartProjectUseCase;

public class StartProjectCli implements ApplicationRunner {

    private final StartProjectUseCase startProjectUseCase;

    public StartProjectCli(StartProjectUseCase startProject) {
        this.startProjectUseCase = startProject;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        startProjectUseCase.startProject(extractProject(args));
    }

    private ProjectProposal extractProject(ApplicationArguments args) {
        return null;
    }

    private BorrowerId extractBorrowerId(ApplicationArguments args) throws IllegalArgumentException {
        return null;
    }
}
