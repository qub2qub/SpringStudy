package by.den.spring.beanFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// identical configuration in Java to the XML above
@Configuration
public class CarConfiguration {

    @Bean
    public MyCarFactoryBean carFactoryBean(){
        MyCarFactoryBean cfb = new MyCarFactoryBean();
        cfb.setMake("Lada");
        cfb.setYear(1998);
        return cfb;
    }

    @Bean
    public Person aPerson() {
        Person person = new Person();
        //you must dereference the FactoryBean explicitly in Java configuration and call getObject()
        person.setCar(carFactoryBean().getObject());
        return person;
    }
}