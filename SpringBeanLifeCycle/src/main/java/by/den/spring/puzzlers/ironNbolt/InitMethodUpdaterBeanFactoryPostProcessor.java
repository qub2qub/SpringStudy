package by.den.spring.puzzlers.ironNbolt;

import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

import javax.annotation.PostConstruct;
import java.lang.reflect.Method;

/**
 * Created by Denis on 11-02-2017
 */
@Component
public class InitMethodUpdaterBeanFactoryPostProcessor implements BeanFactoryPostProcessor {


    @Override
    @SneakyThrows
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] names = beanFactory.getBeanDefinitionNames();
        for (String name : names) {
            /*BeanDefinition*/ AbstractBeanDefinition beanDefinition =
                    (AbstractBeanDefinition) beanFactory.getBeanDefinition(name);
            String beanClassName = beanDefinition.getBeanClassName();
            if (beanClassName == null) {
                beanClassName = UglyUtils.resolveClassNameFromJavaConfig(beanDefinition);
            }
            Class<?> beanClass = Class.forName(beanClassName);
            Class<?>[] allInterfacesForClass = ClassUtils.getAllInterfacesForClass(beanClass);
            for (Class<?> ifc : allInterfacesForClass) {
                Method[] methods = ifc.getMethods();
                for (Method method : methods) {
                    if (method.isAnnotationPresent(PostConstruct.class)) {
                        beanDefinition.setInitMethodName(method.getName());
                        System.out.println("InitMethodUpdaterBFPP >> add init method >> " + method.getName());
                    }
                }
            }
        }
    }
}
