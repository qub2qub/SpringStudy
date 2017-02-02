package by.den.spring.javaConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppContext {

	@Bean(initMethod = "setup", destroyMethod = "cleanup")
	public Course course() {
		Course course = new Course();
		course.setModule(module());
		return course;
	}

	@Bean
	@Scope("prototype")
	public Module module() {
		Module module = new Module();
		module.setAssignment(assignment());
		return module;
	}

	@Bean
	public Assignment assignment() {
		return new Assignment();
	}
}