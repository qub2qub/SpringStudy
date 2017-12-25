package by.den.spring.factoryBean;

import org.springframework.beans.factory.FactoryBean;

import java.awt.*;
import java.util.Random;

public class ColorFactoryBean implements FactoryBean<Color> {
    
    private static final Random RANDOM = new Random();
    
    @Override
    public Color getObject() throws Exception {
        return new Color(RANDOM.nextInt(255), RANDOM.nextInt(255), RANDOM.nextInt(255));
    }

    @Override 
    public Class<?> getObjectType() {
        return Color.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}