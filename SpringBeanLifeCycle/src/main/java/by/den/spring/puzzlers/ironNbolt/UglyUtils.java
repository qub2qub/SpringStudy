package by.den.spring.puzzlers.ironNbolt;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.core.type.MethodMetadata;
import org.springframework.core.type.StandardMethodMetadata;
import org.springframework.core.type.classreading.MethodMetadataReadingVisitor;

import java.lang.reflect.Field;

/**
 * Created by Denis on 11-02-2017
 */
public class UglyUtils {

    private static final String jConfAnnBeanDef = "org.springframework.context.annotation.ConfigurationClassBeanDefinitionReader$ConfigurationClassBeanDefinition";

    public static String resolveClassNameFromJavaConfig(BeanDefinition beanDefinition) {
        try {
            Object reader = Class.forName(jConfAnnBeanDef).cast(beanDefinition);
            Field field = reader.getClass().getDeclaredField("factoryMethodMetadata");
            field.setAccessible(true);
            Object fieldValue = field.get(reader);
            MethodMetadata visitor = null;
            if (fieldValue instanceof MethodMetadataReadingVisitor) {
                visitor = (MethodMetadataReadingVisitor) fieldValue;
            } else if (fieldValue instanceof StandardMethodMetadata) {
                visitor = (StandardMethodMetadata) fieldValue;
            }
            if (visitor != null) {
                return visitor.getReturnTypeName();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
