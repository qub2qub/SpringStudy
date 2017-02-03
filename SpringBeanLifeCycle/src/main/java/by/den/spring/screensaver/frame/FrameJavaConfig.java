package by.den.spring.screensaver.frame;

import org.springframework.context.annotation.*;

import java.awt.*;
import java.util.Random;

/**
 * Created by Denis on 03-02-2017
 */
@Configuration
@ComponentScan("by.den.spring.screensaver") // по дефолту сканит тот же пакет, где лежит данный конфиг
public class FrameJavaConfig {

    @Bean
//    @Scope(value = "prototype")
    @Scope(value = "periodical")
    public Color color() {
        Random random = new Random();
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

    @Bean
    public TrueColorFrame frame() {
        return new TrueColorFrame() {
            @Override
            protected Color getColor() {
                // это не вызов метода color(), а обращение к бину "color"
                return color();
                // а сам Override-эд метод getColor() -- каждый раз будет
                // возвращать новый бин "color", т.к. он указан как prototype.
            }
        };
    }

}
