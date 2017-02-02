package by.den.spring.threePhaseBeanConstructor;

/**
 * Created by Denis on 01 Февраль 2017
 */
public class ProfilerController implements ProfilerControllerMBean {
    private boolean enabled = true;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
