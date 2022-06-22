package pro.howtobe.domainexperiments.crowdsorcery.managingproject.adapters.primary;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import pro.howtobe.domainexperiments.crowdsorcery.managingproject.domain.BorrowerId;
import pro.howtobe.domainexperiments.crowdsorcery.managingproject.usecases.StartProject;

public class StartProjectCli implements ApplicationRunner {

    private final StartProject startProject;

    public StartProjectCli(StartProject startProject) {
        this.startProject = startProject;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        startProject.startProject(extractBorrowerId(args));
    }

    private BorrowerId extractBorrowerId(ApplicationArguments args) throws IllegalArgumentException {
        return null;
    }
}
