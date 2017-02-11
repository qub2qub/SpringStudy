package by.den.spring.puzzlers.factoryBeans;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by Denis on 11-02-2017
 */
public class TestFactories {

    private final String path = "E:\\Git\\github_qub2qub\\SpringStudy\\SpringBeanLifeCycle\\src\\main\\java\\by\\den\\spring\\puzzlers\\factoryBeans\\factoryBeans.xmll";

    @Test
    public void createFactoryBean() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("factoryBeans.xml");

        for (int i = 0; i < 10; i++) {
            System.out.println(context.getBean("rndInt"));
        }
        System.out.println("==================");
        for (int i = 0; i < 10; i++) {
            System.out.println(context.getBean("myIntFactory"));
            System.out.println(context.getBean("myInt"));
        }
    }

}
