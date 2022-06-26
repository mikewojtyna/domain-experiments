package pro.howtobe.domainexperiments.crowdsorcery.managingproject.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pro.howtobe.domainexperiments.crowdsorcery.managingproject.adapters.primary.StartProjectCli;
import pro.howtobe.domainexperiments.crowdsorcery.managingproject.domain.ProjectProposalSupervisor;
import pro.howtobe.domainexperiments.crowdsorcery.managingproject.usecases.StartProjectUseCase;

@Configuration
public class ManagingProjectSpringConfig {

    @Bean
    public ProjectProposalSupervisor startProjectCommandHandler() {
        return new ProjectProposalSupervisor();
    }

    @Bean
    public StartProjectUseCase startProject(ProjectProposalSupervisor startProjectCommandHandler) {
        return new StartProjectUseCase(startProjectCommandHandler);
    }

    @Bean
    public StartProjectCli startProjectCli(StartProjectUseCase startProject) {
        return new StartProjectCli(startProject);
    }
}
