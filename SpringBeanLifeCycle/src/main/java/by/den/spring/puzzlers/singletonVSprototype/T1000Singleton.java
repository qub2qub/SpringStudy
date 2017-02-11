package by.den.spring.puzzlers.singletonVSprototype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by Denis on 11-02-2017
 */
@Component
@Scope("singleton")
public class T1000Singleton {

    @Autowired
    private T800Prototype t800;

    @PostConstruct
    public void setUp() {
        System.out.println("T1000 -- setUp -- where is Sara");
    }

    @PreDestroy
    public void tearDown() {
        System.out.println("T1000 -- tearDown -- a lot of noise");
    }
}
