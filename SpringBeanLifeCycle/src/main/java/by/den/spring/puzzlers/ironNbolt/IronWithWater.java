package by.den.spring.puzzlers.ironNbolt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Denis on 11-02-2017
 */
@Component
public class IronWithWater implements Iron {
    @Override
    public void warmUp() {
        System.out.println("IronWithWater >> Разогреваюсь ...");
    }

//    @PostConstruct // IllegalStateException: Lifecycle method annotation requires a no-arg method
    @Autowired
    public void heatUpWater(Water water) {
        System.out.println("IronWithWater >> Грею воду ... " + water);
    }
}
