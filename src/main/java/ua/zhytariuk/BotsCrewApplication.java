package ua.zhytariuk;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ua.zhytariuk.service.impl.UniversityService;

@SpringBootApplication
@EnableJpaRepositories
public class BotsCrewApplication {

    public static void main(String[] args) {
        final var application = new SpringApplication(BotsCrewApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        final var context = application.run(args);

        context.getBean(UniversityService.class).startCommunication();
    }
}
