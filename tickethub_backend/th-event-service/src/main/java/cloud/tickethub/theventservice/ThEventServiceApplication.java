package cloud.tickethub.theventservice;

import cloud.tickethub.theventservice.event.service.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class ThEventServiceApplication {

    public static void main(String[] args) {


        SpringApplication.run(ThEventServiceApplication.class, args);
    }

    @Bean
    public ApplicationRunner applicationStartupRunner() {
        return new ApplicationRunner();
    }
}
