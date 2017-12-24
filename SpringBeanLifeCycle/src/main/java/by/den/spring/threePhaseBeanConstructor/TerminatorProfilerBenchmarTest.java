package by.den.spring.threePhaseBeanConstructor;

import java.util.Arrays;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TerminatorProfilerBenchmarTest {

    @Test
    public void sayQuote() throws InterruptedException {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext(
                        "threePhaseConstruct.xml");
//org.springframework.beans.factory.NoSuchBeanDefinitionException:
// No qualifying bean of type 'by.den.spring.threePhaseBeanConstructor.Terminator' available
//        Terminator terminator = context.getBean(Terminator.class);

//        Quoter terminator = (Quoter) context.getBean("terminator");
        Quoter terminator = context.getBean(Quoter.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        System.out.println(Arrays.toString(beanDefinitionNames));
        terminator.sayQuote(); // для 1 вызова
    
        // для проверки MBean из  d:\j8u\bin\jvisualvm.exe
        // Ещё надо установить плагин: Tools > Plugins > Install > MBeans
//        while (true) {
//            Thread.sleep(2500);
//            terminator.sayQuote();
//        }
        
    }
}
