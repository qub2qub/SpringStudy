package by.den.spring.threePhaseBeanConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.lang.reflect.Method;

/**
 * Created by Denis on 02-02-2017
 */
public class AfterProxyContextRefreshApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger LOG = LoggerFactory.getLogger(AfterProxyContextRefreshApplicationListener.class);

    @Autowired
    private ConfigurableListableBeanFactory factory;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        LOG.info("onApplicationEvent::event="+event);
        ApplicationContext context = event.getApplicationContext();
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            // потому что нам нельзя загружать бины из контекста,
            // т.к. мы пробегаем по ним всем, а какие-то могут быть lazy init.
            // поэтому нам нужно фактори, которая знает изначальный difinition бинов.
            BeanDefinition beanDefinition = factory.getBeanDefinition(name);
            String originalClassName = beanDefinition.getBeanClassName();
            try {
                // т.к. аннотаций у прокси объекта уже не будет, поэтому
                // нам надо найти оригинальный класс бина, который был загружен фабрикой
                // из исходного описания бина.
                Class<?> originalClass = Class.forName(originalClassName);

                Method[] methods = originalClass.getMethods();
                for (Method method : methods) {
//                    if ("by.den.spring.threePhaseBeanConstructor.Terminator".equalsIgnoreCase(originalClassName)) {
//                        LOG.info("________M="+method.getName());
//                    }
                    if (method.isAnnotationPresent(AfterProxy.class)) {
                        // т.к. надо вызвать метод не у загруженного класса,
                        // а у прокси для бина из контекста (это совсем другой класс, т.к. уже после всех прокси)
                        Object bean = context.getBean(name);
/*
                        Class<?> proxyClass = bean.getClass(); // proxy класс
                        System.out.println("need="+method.getName()+", pt="+method.getParameterTypes());
                        Method[] proxyMethods = proxyClass.getMethods();
                        for (Method pm : proxyMethods) {
                            System.out.println("_m2="+pm.getName() + ", p2="+pm.getParameterTypes());
                        }
                        // java.lang.NoSuchMethodException: com.sun.proxy.$Proxy12.phase3rdContextRefresh()
                        Method currentMethod = proxyClass.getMethod(method.getName(), method.getParameterTypes());
*/
                        Method currentMethod = bean.getClass().getMethod(method.getName(), method.getParameterTypes());

                        // т.к. все Exception уже и так ловятся,
                        // то запускаем прямо так, без  ReflectionUtils
                        currentMethod.setAccessible(true);
                        currentMethod.invoke(bean);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
