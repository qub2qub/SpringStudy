package by.den.spring.puzzlers.prod;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Denis on 11-02-2017
 */
@Configuration
@ComponentScan
public class ProdConfig {

    @Bean
    public String str1()  {
        return "str1";
    }
    @Bean
    public String str2()  {
        return "str1";
    }
    @Bean @ProdQualifier
    public String str3prod()  {
        return "str3prod";
    }
    @Bean @ProdQualifier
    public String str4prod()  {
        return "str4prod";
    }


}
