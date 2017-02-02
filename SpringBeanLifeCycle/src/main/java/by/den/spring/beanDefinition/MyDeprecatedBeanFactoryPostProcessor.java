package by.den.spring.beanDefinition;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyDeprecatedBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
   @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory)
           throws BeansException {

        String[] names = configurableListableBeanFactory.getBeanDefinitionNames();
        for (String name : names) {
            BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition(name);
            String className = beanDefinition.getBeanClassName();
            try {
                Class originalClass = Class.forName(className);
                MyDeprecated annotation = (MyDeprecated) originalClass.getAnnotation(MyDeprecated.class);
                if(annotation != null){
                    Class newClass = annotation.newImpl();
                    beanDefinition.setBeanClassName(newClass.getName());
                }
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
           }
        }
    }
}