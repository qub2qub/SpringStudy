package by.den.spring.puzzlers.factoryBeans;

import org.springframework.beans.factory.FactoryBean;

import java.util.Random;

/**
 * Created by Denis on 11-02-2017
 */
public class MyIntegerFactory {

    private Random random = new Random();

    public Integer getInt() throws Exception {
        /*int res = random.nextInt(10);
        for (int i = 0; i < random.nextInt(10); i++) {
            res = random.nextInt(10);
        }
        return res;*/
        return random.nextInt(10);
    }

}
