package by.den.spring.screensaver.tests;

import by.den.spring.screensaver.frame.ColorFrame1st;
import by.den.spring.screensaver.frame.ColorFrame3rd;
import by.den.spring.screensaver.frame.FrameJavaConfig;
import by.den.spring.screensaver.frame.TrueColorFrame2nd;
import org.junit.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Denis on 03-02-2017
 */
public class ScreenTest {

    private static AnnotationConfigApplicationContext context = null;

    @BeforeClass
    public static void setupOnce() {
        context = new AnnotationConfigApplicationContext(FrameJavaConfig.class);
        for (String name : context.getBeanDefinitionNames()) {
            System.out.println(name);
        }
    }

    @AfterClass
    public static void shutdownOnce() {
        if (context != null) {
            context.close();
            context = null;
        }
    }

    /*@Before
    public void setup() {
        context = new AnnotationConfigApplicationContext(FrameJavaConfig.class);
        for (String name : context.getBeanDefinitionNames()) {
            System.out.println(name);
        }
    }

    @After
    public void shutdown() {
        if (context != null) {
            context.close();
            context = null;
        }
    }*/

    @Test
    public void launchScreenSaver1st() throws InterruptedException {
        while (true) {
            ColorFrame1st frame = context.getBean(ColorFrame1st.class);
            frame.showOnRandomPlace();
            Thread.sleep(500);
        }
    }

    @Test
    public void launchScreenSaver2ndTrue() throws InterruptedException {
        while (true) {
            TrueColorFrame2nd frame = context.getBean(TrueColorFrame2nd.class);
            frame.showOnRandomPlace();
            Thread.sleep(500);
        }
    }

    @Test
    public void launchScreenSaver3rd() throws InterruptedException {
        while (true) {
            ColorFrame3rd frame = context.getBean(ColorFrame3rd.class);
            frame.showOnRandomPlace();
            Thread.sleep(500);
        }
    }

}
