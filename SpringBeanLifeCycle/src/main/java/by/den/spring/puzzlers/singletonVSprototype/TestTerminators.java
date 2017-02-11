package by.den.spring.puzzlers.singletonVSprototype;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Denis on 11-02-2017
 */
public class TestTerminators {

    @Test
    public void openCloseContext() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(
                        "by.den.spring.puzzlers.singletonVSprototype");
        context.close();
    }
}
