package by.den.spring.screensaver.tests;

import java.util.Arrays;

import by.den.spring.screensaver.frame.Frame1Simple;
import by.den.spring.screensaver.frame.Frame3Supplier;
import by.den.spring.screensaver.frame.FrameJavaConfig;
import by.den.spring.screensaver.frame.Frame2AbstractMethod;
import org.junit.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScreenTest {

    private static AnnotationConfigApplicationContext context = null;

    @BeforeClass
    public static void setupOnce() {
        context = new AnnotationConfigApplicationContext(FrameJavaConfig.class);
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
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
            Frame1Simple frame = (Frame1Simple) context.getBean("frame1st");
            frame.setVisible(true);
            frame.showOnRandomPlace();
            Thread.sleep(500);
        }
    }

    @Test
    public void launchScreenSaver2ndTrue() throws InterruptedException {
        while (true) {
            Frame2AbstractMethod frame = context.getBean(Frame2AbstractMethod.class);
            frame.setVisible(true);
            frame.showOnRandomPlace();
            Thread.sleep(500);
        }
    }

    @Test
    public void launchScreenSaver3rd() throws InterruptedException {
        while (true) {
            Frame3Supplier frame = context.getBean(Frame3Supplier.class);
            frame.setVisible(true);
            frame.showOnRandomPlace();
            Thread.sleep(500);
        }
    }

}
