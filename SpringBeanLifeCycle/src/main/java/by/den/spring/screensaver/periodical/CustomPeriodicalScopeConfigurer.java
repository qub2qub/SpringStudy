package by.den.spring.screensaver.periodical;

import javafx.util.Pair;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class CustomPeriodicalScopeConfigurer implements Scope {
    
    public static final String PERIODICAL = "periodical";
    private static final int CHANGE_COLOR_TIME = 3;
    private Map<String, Pair<LocalTime, Object>> map = new HashMap<>();

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        if (map.containsKey(name)) {
            Pair<LocalTime, Object> localTimeObjectPair = map.get(name);
            // см туториал по времени в java 8
            // https://docs.oracle.com/javase/tutorial/datetime/iso/period.html
            long secondsSinceLastRequest = ChronoUnit.SECONDS.between(
                    localTimeObjectPair.getKey(), LocalTime.now());
            System.out.println("CustomPeriodicalScopeConfigurer :: secondsSinceLastRequest = " + secondsSinceLastRequest);
            if (secondsSinceLastRequest > CHANGE_COLOR_TIME) {
                //if exceeded, then create new pair and take bean again (color will be changed randomly)
                map.put(name, new Pair<>(LocalTime.now(), objectFactory.getObject()));
            }
        } else {
            //put if not existed
            map.put(name, new Pair<>(LocalTime.now(), objectFactory.getObject()));
        }
        return map.get(name).getValue();
    }

    @Override
    public Object remove(String name) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
