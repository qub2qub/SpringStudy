package by.den.spring.threePhaseBeanConstructor;

import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.lang.reflect.Method;

public class AfterProxyContextRefreshApplicationListener implements
  ApplicationListener<ContextRefreshedEvent> { // Generics for special type of event
  
  private static final Logger LOG = LoggerFactory.getLogger(AfterProxyContextRefreshApplicationListener.class);
  
  // в спринг инжектуть спринг - это норм
  @Autowired
  private ConfigurableListableBeanFactory factory;
  
  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
//    LOG.info("onApplicationEvent::event=" + event);
    ApplicationContext context = event.getApplicationContext();
    String[] names = context.getBeanDefinitionNames();
    for (String beanWithAfterProxyMethod : names) {
      // потому что нам нельзя загружать бины из контекста, т.к. какие-то могут быть lazy init.
      // а если бы мы их получали как context.getBean(..) - он бы тут и создался.
      // поэтому нам нужно фактори, которая знает изначальный difinition бинов.
      BeanDefinition beanDefinition = factory.getBeanDefinition(beanWithAfterProxyMethod);
      String originalClassName = beanDefinition.getBeanClassName();
      // Т.к. JavaConfig не вернёт класс для бина
      if (originalClassName == null) {
        continue; // но не тру вариант !
      }
      try {
        // т.к. аннотаций у прокси объекта уже не будет, поэтому нам надо найти оригинальный класс бина,
        // который был загружен фабрикой из исходного описания бина.
        Class<?> originalClass = Class.forName(originalClassName);
        Method[] methods = originalClass.getMethods();
        for (Method method : methods) {
          if (method.isAnnotationPresent(AfterProxy.class)) {
            LOG.info("@AfterProxy____call____="+originalClassName+"." + method.getName()+"(..)");
            // т.к. надо вызвать метод не у загруженного класса,
            // а у прокси для бина из контекста (это совсем другой класс, т.к. уже после всех прокси)
            Object bean = context.getBean(beanWithAfterProxyMethod); // class=com.sun.proxy.$Proxy7
            Class<?> proxyClass = bean.getClass(); // proxy класс
            // У прокси не будет методов из исходного класса, только методы из интерфейса
//            Arrays.stream(proxyClass.getMethods()).forEach(m -> {
//              System.out.println("_proxyClass_method=" + m.getName() + ", __params=" + Arrays.toString(m.getParameterTypes()));
//            });
            Method proxyClassMethod = proxyClass.getMethod(method.getName(), method.getParameterTypes());
            // т.к. все Exception уже и так ловятся, то запускаем прямо так, без  ReflectionUtils
            proxyClassMethod.setAccessible(true);
            proxyClassMethod.invoke(bean);
          }
        }
      } catch (Exception e) {
        LOG.error("Error in BPP for Spring ContextRefresh:", e);
      }
    }
  }
}
