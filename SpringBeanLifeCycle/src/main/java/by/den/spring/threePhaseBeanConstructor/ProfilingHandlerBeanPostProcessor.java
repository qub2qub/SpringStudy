package by.den.spring.threePhaseBeanConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * Не очень работает.
 */
public class ProfilingHandlerBeanPostProcessor implements BeanPostProcessor {

    private static final Logger LOG = LoggerFactory.getLogger(ProfilingHandlerBeanPostProcessor.class);

    private Map<String, Class> beans = new HashMap<>();
    private ProfilerController profilerController = new ProfilerController();

    public ProfilingHandlerBeanPostProcessor() throws Exception {
        MBeanServer platformMBeanServer = ManagementFactory.getPlatformMBeanServer();
        platformMBeanServer.registerMBean(profilerController,
                new ObjectName("profiling", "name", "controller"));
    }

    @Override
    public Object postProcessBeforeInitialization(final Object bean, String beanName) throws BeansException {
        Class originalClass = bean.getClass();
        if (originalClass.isAnnotationPresent(Profiler.class)) {
            LOG.info("postProcessBeforeInitialization::Save bean for later >> beanName = {}, beanClass = {}",
                    beanName, bean.getClass().getName());
            beans.put(beanName, originalClass);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(final Object bean, String beanName) throws BeansException {

        Class originalClass = beans.get(beanName);
        if (originalClass != null) {

            return Proxy.newProxyInstance(
                    originalClass.getClassLoader(),
                    originalClass.getInterfaces(),

                    (proxy, method, args) -> {
                        if (profilerController.isEnabled()) {
                            long before = System.nanoTime();
                            Object retVal = method.invoke(bean, args);
                            long after = System.nanoTime();
                            LOG.info(originalClass.getName()+"."+method.getName()+"(..) работал: "+(after-before)+" наносекунд");
                            return retVal;
                        } else {
                            return method.invoke(bean, args);
                        }
                    });
        }
        return bean;
    }

}