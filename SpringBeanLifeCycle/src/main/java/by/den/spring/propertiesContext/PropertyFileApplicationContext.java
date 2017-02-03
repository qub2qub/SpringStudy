package by.den.spring.propertiesContext;

import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

/**
 * Created by Denis on 03-02-2017
 */
public class PropertyFileApplicationContext extends GenericApplicationContext {
    public PropertyFileApplicationContext(String fileName) {
        PropertiesBeanDefinitionReader reader = new PropertiesBeanDefinitionReader(this);
        int foundBeans = reader.loadBeanDefinitions(fileName);
        System.out.println("foundBeans = " + foundBeans);
        refresh();
    }
}
