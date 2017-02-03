package by.den.spring.screensaver.tests;

import by.den.spring.screensaver.frame.ColorFrame;
import by.den.spring.screensaver.frame.FrameJavaConfig;
import by.den.spring.screensaver.frame.TrueColorFrame;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * Created by Denis on 03-02-2017
 */
public class ScreenTest {

    @Test
    public void launchScreenSaver() throws InterruptedException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(
                        FrameJavaConfig.class);
        for (String name : context.getBeanDefinitionNames()) {
            System.out.println(name);
        }
        while (true) {
            TrueColorFrame frame = context.getBean(TrueColorFrame.class);
            frame.showOnRandomPlace();
            Thread.sleep(500);
        }
    }

}
