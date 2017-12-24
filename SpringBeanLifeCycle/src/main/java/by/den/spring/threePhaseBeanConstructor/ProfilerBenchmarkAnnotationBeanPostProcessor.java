package by.den.spring.threePhaseBeanConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * Не очень работает.
 */
@Component // для другого примера, где не ис-ся xml конфиг, а ис-ся скан пакета.
public class ProfilerBenchmarkAnnotationBeanPostProcessor implements BeanPostProcessor, Ordered {
  
  private static final Logger LOG = LoggerFactory
    .getLogger(ProfilerBenchmarkAnnotationBeanPostProcessor.class);
  
  private Map<String, Class> originalBeanIdsNClasses = new HashMap<>();
  private ProfilerController profilerController = new ProfilerController();
  
  public ProfilerBenchmarkAnnotationBeanPostProcessor() throws Exception {
    MBeanServer platformMBeanServer = ManagementFactory.getPlatformMBeanServer();
    platformMBeanServer.registerMBean(profilerController,
      new ObjectName("by.den.ProfilerBenchmark", "name", "ToggleProfiling"));
  }
  
  @Override
  public Object postProcessBeforeInitialization(final Object bean, String beanName)
    throws BeansException {
    Class originalClass = bean.getClass();
    if (originalClass.isAnnotationPresent(ProfilerBenchmark.class)) {
      LOG.info("ProfilerBenchmarkBPP.BeforeInit::Save orig bean >> "
        + "beanName = {}, beanClass = {}", beanName, bean.getClass().getName());
      originalBeanIdsNClasses.put(beanName, originalClass);
    }
    return bean;
  }
  
  @Override
  public Object postProcessAfterInitialization(final Object bean, String beanName)
    throws BeansException {
    
    // Здесь в бине уже может быть прокси, и оригинальных аннотаций уже не будет
    // поэтому надо брать бин из наших ранее сохранённых.
    Class originalClass = originalBeanIdsNClasses.get(beanName);
    if (originalClass != null) { // значит запомнил и над ним стояла аннотация @ProfilerBenchmark
      LOG.info("Set @ProfilerBenchmark PROXY for >> " + originalClass);
      return Proxy.newProxyInstance(
        originalClass.getClassLoader(),
        originalClass.getInterfaces(),
        // инкапсулирует локигу, которая попадёт во все методы сгенеренного класса
        (proxy, method, args) -> {
          // проверить, включён ли флаг для профилирования
          if (profilerController.isEnabled()) {
            String methodName = originalClass.getName() + "." + method.getName() + "(..)";
            LOG.info("@ProfilerBenchmark __ start >> " + methodName);
            long before = System.nanoTime();
            Object returnedValue = method.invoke(bean, args);
            long after = System.nanoTime();
            LOG.info("@ProfilerBenchmark __ end_ >> " + methodName + " работал: " + (after - before) + " наносекунд\n");
            return returnedValue;
          } else {
            return method.invoke(bean, args);
          }
        });
    }
    return bean;
  }
  
  @Override
  public int getOrder() {
    return 1000;
  }
}