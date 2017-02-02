package by.den.spring.javaConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;

/**
 * Created by Denis on 22 Январь 2017
 */
public class RunJavaConfig {
    public static void main(String[] args) throws UnsupportedEncodingException {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);

        // Альтернатива
//        ApplicationContext ctx = new AnnotationConfigApplicationContext();
//        ctx.register(AppContext.class)
        // можно зарерить несколько классов.

        Course course = ctx.getBean(Course.class);

    }
}
