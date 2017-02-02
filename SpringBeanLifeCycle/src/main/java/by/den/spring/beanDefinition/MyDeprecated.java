package by.den.spring.beanDefinition;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyDeprecated {
    public Class newImpl() default Class.class;
}