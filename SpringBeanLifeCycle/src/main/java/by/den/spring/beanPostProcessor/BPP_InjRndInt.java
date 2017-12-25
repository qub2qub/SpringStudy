package by.den.spring.beanPostProcessor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Random;


public class BPP_InjRndInt implements BeanPostProcessor {

    private Random random = new Random();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            InjRndIntANN annotation = field.getAnnotation(InjRndIntANN.class);
            if (annotation != null) {
                if(Number.class.isAssignableFrom(field.getType())) {
                    System.out.println("BPP_InjRndInt >>> field is Number = " + field.getName());
                } else {
                    throw new RuntimeException("Current field is not a Number "+ field.getName()+"::" + field.getType());
                }
                if (Modifier.isFinal(field.getModifiers())) {
                    throw new RuntimeException("can't inject to final fields");
                }
                int min = annotation.min();
                int max = annotation.max();
                int randomInt = min + random.nextInt(max - min);
                try {
                    field.setAccessible(true);
                    field.set(bean,randomInt);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

}