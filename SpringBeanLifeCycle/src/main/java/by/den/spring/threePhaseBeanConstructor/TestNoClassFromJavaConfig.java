package by.den.spring.threePhaseBeanConstructor;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Denis on 08-02-2017
 */
public class TestNoClassFromJavaConfig {

    @Test
    public void loadBeanFromJavaConfig() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BPPJavaConfig.class);
        Object myStr = context.getBean("myStr");
        System.out.println("myStr = " + myStr);
    }

}
