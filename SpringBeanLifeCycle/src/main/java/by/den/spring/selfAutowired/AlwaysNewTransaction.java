package by.den.spring.selfAutowired;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Denis on 03-02-2017
 */
@Retention(RetentionPolicy.RUNTIME)
@Transactional
public @interface AlwaysNewTransaction {
    /*
    В 4-м спринге полностью заоверрайдит дефолтное значение из аннотации @Transactional
    В 3-м -- нет, дефолтное значение будет считано из оригинальной аннотации @Transactional
     */
    Propagation propagation() default Propagation.REQUIRES_NEW;
}
