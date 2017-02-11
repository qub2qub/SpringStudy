package by.den.spring.puzzlers.singletonVSprototype;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by Denis on 11-02-2017
 */
@Component
@Scope("prototype")
public class T800Prototype {

    @PostConstruct
    public void setUp() {
        System.out.println("T800 -- setUp -- need clothes");
    }

    @PreDestroy
    public void tearDown() {
        System.out.println("T800 -- tearDown -- astalavista");
    }

}
