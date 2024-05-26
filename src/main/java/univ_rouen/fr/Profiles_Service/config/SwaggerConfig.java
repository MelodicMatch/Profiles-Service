package univ_rouen.fr.Profiles_Service.config;



import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi apiProfiles() {
        return GroupedOpenApi.builder()
                .group("Profiles API")
                .packagesToScan("univ_rouen.fr.Profiles_Service.controller")
                .pathsToMatch("/profiles/**")
                .build();
    }
}
