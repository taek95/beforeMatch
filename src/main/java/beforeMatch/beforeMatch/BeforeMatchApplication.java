package beforeMatch.beforeMatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // auditing 기능 사용하기 위해
@SpringBootApplication
public class BeforeMatchApplication {


	public static void main(String[] args) {
		SpringApplication.run(BeforeMatchApplication.class, args);
	}

}
