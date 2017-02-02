package by.den.spring.annotationConfig;

import by.den.spring.annotationConfig.animals.Animal;
import by.den.spring.annotationConfig.human.*;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Created by Denis on 02-02-2017
 */
@Configuration
@ComponentScan(basePackages = {"by.den.spring.annotationConfig.animals"})
public class AnimalsJavaConfig {

    /**
     * Инача 2 бина типа Humanoid, например, когда из контекста брать по классу Human.
     */
    @Bean
    Humanoid deadHumanoid() {
        return new Humanoid() {
            @Override
            public void stand() {
                System.out.println("I'm dead! Cannot stand !");
            }
        };
    }

    @Bean
    Animal snake() {
        return new Animal() {
            @Override
            public String myNameIs() {
                return "Snake";
            }

            @Override
            public void voice() {
                System.out.println("SSSSSSSSS");
            }
        };
    }

    @Bean(initMethod = "wakeUp")
    Human JasonBorn() {
        Human human = new Human();
        human.setHead(genHead());
        human.setLegs(genLegs());
        return human;
    }

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    Legs genLegs() {
        return new HumanLegs();
    }

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    Head genHead() {
        HumanHead head = new HumanHead();
        head.setEyes(genEyes());
        return head;
    }

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    Eyes genEyes() {
        return new HumanEyes();
    }

}
