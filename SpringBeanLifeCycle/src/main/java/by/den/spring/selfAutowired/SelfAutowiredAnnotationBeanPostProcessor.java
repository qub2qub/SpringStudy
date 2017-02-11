package by.den.spring.selfAutowired;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Denis on 03-02-2017
 */
@Component
public class SelfAutowiredAnnotationBeanPostProcessor implements BeanPostProcessor, Ordered {

    private Map<String, Object> beans = new HashMap<>();
    // по-хорошему надо запомнить все филды с @SelfAutowired,
    // чтобы на 2м этапе быстро по ним пройтись

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        Field[] declaredFields = bean.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(SelfAutowired.class)) {
                beans.put(beanName, bean);
                break;
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        // !! на самом деле не факт, что этот наш BPP вызовется самым последним,
        // [хуйня]поэтому правильнее сетать эту фигню на этапе Context.refresh(). см трёхуровневый конструктор
        // [правильно] описать интерфейс Ordered
        Object originalClass = beans.get(beanName);
        if (originalClass != null) {
            Field[] declaredFields = originalClass.getClass().getDeclaredFields();
            for (Field field : declaredFields) {
                if (field.isAnnotationPresent(SelfAutowired.class)) {
                    System.out.println("Set @SelfAutowired PROXY for >> "+originalClass +"\n PROXY="+bean);
                    field.setAccessible(true);
                    ReflectionUtils.setField(field, originalClass, bean);
                }
            }
        }

        return bean;
    }

    /*
    Ещё проблема была в том, что у другого BPP не было проставлен Ordered порядковый номер,
    и поэтому он загружался после текущего BPP, у которго  LOWEST_PRECEDENCE !! странно.
    В итоге первому проставил порядок, и текущий BPP загрузился последним и всё заработало.
     */
    @Override
    public int getOrder() {
        return LOWEST_PRECEDENCE;
    }

}
