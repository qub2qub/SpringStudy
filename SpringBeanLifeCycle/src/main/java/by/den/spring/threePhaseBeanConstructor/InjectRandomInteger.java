package by.den.spring.threePhaseBeanConstructor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация которая в поле типа Integer
 * инжектит рандомное число от min до max;
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface InjectRandomInteger {
    int min() default 0;
    int max() default 10;
}