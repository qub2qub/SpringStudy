package by.den.spring.factoryBean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.awt.*;

/**
 * Created by Denis on 22 Январь 2017
 */
public class RunFactoryBean {
    public static void main(String[] args) {

        AbstractApplicationContext context = new ClassPathXmlApplicationContext("bean-factory.xml");
        context.registerShutdownHook();

        AbstractApplicationContext jctx = new AnnotationConfigApplicationContext(CarConfiguration.class);
        jctx.registerShutdownHook();
//        jctx.refresh(); // может тут и не надо делать рефреш

        System.out.println("\n_________ Spring 2 Contexts Loaded _________");

        Person aPerson = (Person) jctx.getBean("aPerson");
        System.out.println("person1 = " + aPerson);

        Person josh = (Person) context.getBean("josh");
        System.out.println("person2 = " + josh);

        Color color = (Color) context.getBean("colorFactoryBean");
        System.out.println("color = " + color);

        jctx.close();
        context.close();
        System.out.println("\n_________ Spring Context Closed _________");
    }
}
