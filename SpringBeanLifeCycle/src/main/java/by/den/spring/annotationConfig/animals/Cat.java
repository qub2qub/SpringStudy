package by.den.spring.annotationConfig.animals;

import org.springframework.stereotype.Component;

/**
 * Created by Denis on 02-02-2017
 */
@Component
public class Cat implements Animal {
    @Override
    public String myNameIs() {
        return "Cat";
    }

    @Override
    public void voice() {
        System.out.println("FFFFFF");
    }
}
