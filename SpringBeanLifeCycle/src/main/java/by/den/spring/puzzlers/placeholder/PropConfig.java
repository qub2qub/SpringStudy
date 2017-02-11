package by.den.spring.puzzlers.placeholder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Created by Denis on 11-02-2017
 */
@Configuration
@ComponentScan
public class PropConfig {

    @Value("${JAVA_HOME}")
    private String javaHome;

    @PostConstruct
    private void init() {
        System.out.println("PropConfig --- @PostConstruct --- " + javaHome);
    }

//    @Bean(initMethod = "initPropService") // не найдёт этот метод, т.к. он с параметрами
    @Bean(initMethod = "noArgInitPropService") // ОК
//    @Bean
    public PropService propService() {
        return new PropService();
    }

}
