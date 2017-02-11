package by.den.spring.puzzlers.ironNbolt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Denis on 11-02-2017
 */
@Configuration
@ComponentScan
public class ПаяльникJavaConfig {

    @Bean
    public Паяльник bigBolt() {
        return new БольшойПаяльник();
    }

}
