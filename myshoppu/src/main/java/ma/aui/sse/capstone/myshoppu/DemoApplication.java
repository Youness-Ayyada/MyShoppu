package ma.aui.sse.capstone.myshoppu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;

import ma.aui.sse.capstone.myshoppu.data.entities.User;
import ma.aui.sse.capstone.myshoppu.security.UserAuditor;
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
    AuditorAware<User> auditorProvider() {
        return new UserAuditor();
    }
}
