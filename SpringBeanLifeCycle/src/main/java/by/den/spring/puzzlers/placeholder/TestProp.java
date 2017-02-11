package by.den.spring.puzzlers.placeholder;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Denis on 11-02-2017
 */
public class TestProp {

    @Test
    public void loadJavaHome() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PropConfig.class);
        PropService service = context.getBean(PropService.class);
        System.out.println("Done !");
    }

}
