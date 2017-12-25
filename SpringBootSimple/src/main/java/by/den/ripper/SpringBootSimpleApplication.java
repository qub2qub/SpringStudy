package by.den.ripper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootSimpleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSimpleApplication.class, args);
	}
}
