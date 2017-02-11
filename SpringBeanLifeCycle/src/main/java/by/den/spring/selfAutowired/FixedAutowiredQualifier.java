package by.den.spring.selfAutowired;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Denis on 11-02-2017
 */
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface FixedAutowiredQualifier {
}
