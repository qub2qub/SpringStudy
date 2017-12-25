package by.den.spring.factoryBean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.awt.*;

public class RunFactoryBean {
    public static void main(String[] args) throws InterruptedException {

        AbstractApplicationContext context = new ClassPathXmlApplicationContext("factory-bean.xml");
        context.registerShutdownHook();
        Color color = (Color) context.getBean("colorFactoryBean");
        System.out.println("color1 = " + color);
        color = (Color) context.getBean("colorFactoryBean");
        System.out.println("color2 = " + color);
        color = (Color) context.getBean("colorFactoryBean");
        System.out.println("color3 = " + color);
        Thread.sleep(500);
        
        AbstractApplicationContext carContext = new AnnotationConfigApplicationContext(CarConfiguration.class);
        carContext.registerShutdownHook();
//        carContext.refresh(); // может тут и не надо делать рефреш
        System.out.println("\n_________ Spring 2 Contexts Loaded _________");
        Person aPerson = (Person) carContext.getBean("aPerson");
        System.out.println("person1 = " + aPerson);
        Person bobbyXML = context.getBean(Person.class);
        System.out.println("person2 = " + bobbyXML);
        
        context.close();
        carContext.close();
        System.out.println("\n_________ Spring Context Closed _________");
    }
}
