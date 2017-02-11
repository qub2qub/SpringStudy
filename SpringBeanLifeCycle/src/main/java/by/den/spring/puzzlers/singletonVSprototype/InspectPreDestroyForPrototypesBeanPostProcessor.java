package by.den.spring.puzzlers.singletonVSprototype;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.lang.reflect.Method;

/**
 * Created by Denis on 11-02-2017
 */
@Component
public class InspectPreDestroyForPrototypesBeanPostProcessor implements BeanPostProcessor {

    private static final Logger LOG = LoggerFactory.getLogger(InspectPreDestroyForPrototypesBeanPostProcessor.class);

    @Autowired
    private ConfigurableListableBeanFactory factory;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        BeanDefinition beanDefinition = factory.getBeanDefinition(beanName);
        if (beanDefinition instanceof AbstractBeanDefinition) {
            AbstractBeanDefinition bd = (AbstractBeanDefinition) beanDefinition;
            if (bd.isPrototype()) {
                // 1-Й ВАРИАНТ
                // ДЛЯ XML ИЛИ JAVA-CONFIG
                if (bd.getDestroyMethodName() != null) {
                    LOG.info("Fix for '"+beanName+"', method="+ bd.getDestroyMethodName());
                    return bean; // skip the rest code
                }

                // 2-Й ВАРИАНТ
                // ДЛЯ АННОТАЦИЙ
                Method[] methods = bean.getClass().getMethods();
                for (Method method : methods) {
                    if (method.isAnnotationPresent(PreDestroy.class)) {
                        LOG.info("!!! WARN !!! " + beanName+ "." + method.getName() + "() -> DestroyMethod WON'T be called !! " );
                    }
                }
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
