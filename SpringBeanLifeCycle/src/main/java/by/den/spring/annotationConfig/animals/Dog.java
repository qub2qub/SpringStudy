package by.den.spring.annotationConfig.animals;

import org.springframework.stereotype.Component;

/**
 * Created by Denis on 02-02-2017
 */
@Component
public class Dog implements Animal {

    @Override
    public String myNameIs() {
        return "Dog";
    }

    @Override
    public void voice() {
        System.out.println("RRRRRRRRR");
    }
}
