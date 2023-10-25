package cloud.tickethub.theventservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ThEventServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThEventServiceApplication.class, args);
    }

}
