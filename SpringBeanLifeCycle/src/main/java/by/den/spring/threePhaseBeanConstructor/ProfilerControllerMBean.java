package by.den.spring.threePhaseBeanConstructor;

/**
 * MBeanServer поднимается всесте с запуском Java Process,
 * и MBeanServer регистрирует данный объект, и позже в JMX Console
 * его можно будет менять, запускать его методы
 */
public interface ProfilerControllerMBean {
    void setEnabled(boolean enabled);
}
