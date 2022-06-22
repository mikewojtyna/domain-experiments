package pro.howtobe.domainexperiments.crowdsorcery.managingproject.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pro.howtobe.domainexperiments.crowdsorcery.managingproject.adapters.primary.StartProjectCli;
import pro.howtobe.domainexperiments.crowdsorcery.managingproject.adapters.secondary.InMemoryBorrowerRepository;
import pro.howtobe.domainexperiments.crowdsorcery.managingproject.domain.BorrowerRepository;
import pro.howtobe.domainexperiments.crowdsorcery.managingproject.domain.StartProjectCommandHandler;
import pro.howtobe.domainexperiments.crowdsorcery.managingproject.domain.StartProjectCommandHandlerImpl;
import pro.howtobe.domainexperiments.crowdsorcery.managingproject.usecases.StartProject;

@Configuration
public class ManagingProjectSpringConfig {

    @Bean
    public StartProjectCommandHandler startProjectCommandHandler() {
        return new StartProjectCommandHandlerImpl();
    }

    @Bean
    public BorrowerRepository borrowerRepository() {
        return new InMemoryBorrowerRepository();
    }

    @Bean
    public StartProject startProject(BorrowerRepository borrowerRepository,
                                     StartProjectCommandHandler startProjectCommandHandler) {
        return new StartProject(borrowerRepository, startProjectCommandHandler);
    }

    @Bean
    public StartProjectCli startProjectCli(StartProject startProject) {
        return new StartProjectCli(startProject);
    }
}
