package by.den.spring.threePhaseBeanConstructor;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Denis on 01-02-2017
 */
public class TestTerminator {

    @Test
    public void sayQuote() throws InterruptedException {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext(
                        "threePhaseConstruct.xml");
//org.springframework.beans.factory.NoSuchBeanDefinitionException:
// No qualifying bean of type 'by.den.spring.threePhaseBeanConstructor.Terminator' available
//        Terminator terminator = context.getBean(Terminator.class);

        Quoter terminator = (Quoter) context.getBean("terminator");
        terminator.sayQuote(); // для 1 вызова

//        while (true) { // для проверки MBean из\jdk8u\bin\jvisualvm.exe
//            Thread.sleep(300);
//            terminator.sayQuote();
//        }
    }
}
