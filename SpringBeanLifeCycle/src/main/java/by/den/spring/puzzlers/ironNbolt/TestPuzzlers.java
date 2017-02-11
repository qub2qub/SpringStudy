package by.den.spring.puzzlers.ironNbolt;

import by.den.spring.puzzlers.prod.ProdConfig;
import by.den.spring.puzzlers.prod.ProdService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Denis on 11-02-2017
 */
public class TestPuzzlers {

    @Test
    public void heatWaterIron() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(
                        "by.den.spring.puzzlers");
        System.out.println("DONE !");
    }

    @Test
    public void testПаяльникJavaConfig() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(
                        ПаяльникJavaConfig.class);
//        Паяльник bolt = context.getBean(Паяльник.class);
        Паяльник bolt = (Паяльник) context.getBean("bigBolt");
        System.out.println("DONE !");
    }

    @Test
    public void fillList() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(
                        ProdConfig.class);
//        context.getBean("allStrList");
        ProdService service = context.getBean(ProdService.class);
        System.out.println("all____StrList = " + service.allStrList);
        System.out.println("prod__StrList = " + service.prodStrList);
        System.out.println("DONE !");
    }
}
