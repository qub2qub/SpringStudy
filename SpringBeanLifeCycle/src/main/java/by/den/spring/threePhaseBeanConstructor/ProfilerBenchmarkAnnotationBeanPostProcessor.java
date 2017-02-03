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

    private static final Logger LOG = LoggerFactory.getLogger(ProfilerBenchmarkAnnotationBeanPostProcessor.class);

    private Map<String, Class> beans = new HashMap<>();
    private ProfilerController profilerController = new ProfilerController();

    public ProfilerBenchmarkAnnotationBeanPostProcessor() throws Exception {
        MBeanServer platformMBeanServer = ManagementFactory.getPlatformMBeanServer();
        platformMBeanServer.registerMBean(profilerController,
                new ObjectName("profiling", "name", "controller"));
    }

    @Override
    public Object postProcessBeforeInitialization(final Object bean, String beanName) throws BeansException {
        Class originalClass = bean.getClass();
        if (originalClass.isAnnotationPresent(ProfilerBenchmark.class)) {
//            LOG.info("postProcessBeforeInitialization::Save bean for later >> beanName = {}, beanClass = {}",
//                    beanName, bean.getClass().getName());
            beans.put(beanName, originalClass);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(final Object bean, String beanName) throws BeansException {
        /*
        Здесь в бине уже может быть прокси, и оригинальных аннотаций уже не будет
        поэтому надо брать бин из наших ранее сохранённых.
         */
        Class originalClass = beans.get(beanName);
        if (originalClass != null) {
            System.out.println("Set @ProfilerBenchmark PROXY for >> " + originalClass);
            return Proxy.newProxyInstance(
                    originalClass.getClassLoader(),
                    originalClass.getInterfaces(),

                    (proxy, method, args) -> {
                        if (profilerController.isEnabled()) {
                            long before = System.nanoTime();
//                            LOG.info("@ProfilerBenchmark __ start >> "+originalClass.getName()+"."+method.getName()+"(..)");
                            Object retVal = method.invoke(bean, args);
                            long after = System.nanoTime();
                            LOG.info("@ProfilerBenchmark __ end >> "
                                    +originalClass.getSimpleName()+"."+method.getName()
                                    +"(..) работал: "+(after-before)+" наносекунд");
                            return retVal;
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