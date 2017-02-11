package by.den.spring.selfAutowired;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Denis on 03-02-2017
 */
public class TestProxyCallProblem {

    @Test
    public void callAnotherMethodFromAnnotated() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SelfAutowiredConfig.class);
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

    @Test
    // НО НИХУЯ НЕ РАБОТАЕТ !
    public void fixAutowired() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(
                        SelfAutowiredConfig.class);

        ThreeMethods fixed = (ThreeMethods) context.getBean("fixedAutowireMyself");
        /*
        org.springframework.beans.factory.BeanCurrentlyInCreationException:
        Error creating bean with name 'fixedAutowireMyself': Bean with name 'fixedAutowireMyself'
        has been injected into other beans [fixedAutowireMyself] in its raw version as part of
         a circular reference, but has eventually been wrapped. This means that said other beans
         do not use the final version of the bean. This is often the result of over-eager type matching -
         consider using 'getBeanNamesOfType' with the 'allowEagerInit' flag turned off, for example.
         */
        fixed.aaa();
        fixed.bbb();
        fixed.cccProblem();

    }

}
