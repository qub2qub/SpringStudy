package by.den.spring.selfAutowired;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Denis on 03-02-2017
 */
/*
@ComponentScan По умолчанию если не задать никаких пакетов --
сканирует тот же пакет, где определён текущий класс с @Configuration.

 А если всё-таки задать что именно сканировать --
 то сканирует ТОЛЬКО указанные пакеты (текущий пакет не сканирует.)
 */
@Configuration
@ComponentScan(basePackages = {
        "by.den.spring.threePhaseBeanConstructor",
        "by.den.spring.selfAutowired"})
public class SelfAutowiredConfig {

}
