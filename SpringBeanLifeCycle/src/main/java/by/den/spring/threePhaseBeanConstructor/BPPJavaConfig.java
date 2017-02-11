package by.den.spring.threePhaseBeanConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Denis on 08-02-2017
 */
@Configuration
@ComponentScan
public class BPPJavaConfig {

    @Bean
    public String myStr() {
        return "Single_String_Bean";
    }
}
