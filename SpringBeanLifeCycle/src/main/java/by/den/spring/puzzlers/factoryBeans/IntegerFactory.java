package by.den.spring.puzzlers.factoryBeans;

import org.springframework.beans.factory.FactoryBean;

import java.util.Random;

/**
 * Created by Denis on 11-02-2017
 */
public class IntegerFactory implements FactoryBean<Integer> {

    private Random random = new Random();

    @Override
    public Integer getObject() throws Exception {
        return random.nextInt(10);
    }

    @Override
    public Class<?> getObjectType() {
        return Integer.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
