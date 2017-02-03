package by.den.spring.annotationOverriding;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Denis on 03-02-2017
 */
public class TestProxyCallProblem {

    @Test
    public void callAnotherMethodFromAnnotated() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnnOverrJConfig.class);
//        ProxyMethodCallProblem problem = context.getBean(ProxyMethodCallProblem.class);
        ThreeMethods problem = context.getBean(ThreeMethods.class);

        problem.aaa(); // профайлер вызовется

        problem.bbb();  // профайлер вызовется

        // профайлер вызовется только для метода ссс, но не вложенного bbb()
        // т.к. второй метод bbb() вызывается самим классом напряму, а не через прокси
        problem.cccProblem();
        // чтобы пофикси надо в самом классе вызывать метод через самовпрыскивание:
        // т.е. получить откуда-то ссылку на самого себя и из неё дёрнуть метод.
        // забавно но факт: кое-как это можно сделать через @Resource -- но это всё равно неправильно
    }

}
