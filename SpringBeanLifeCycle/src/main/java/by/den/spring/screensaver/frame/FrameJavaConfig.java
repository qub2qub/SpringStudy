package by.den.spring.screensaver.frame;

import org.springframework.context.annotation.*;

import java.awt.*;
import java.util.Random;
import java.util.function.Supplier;

/**
 * Created by Denis on 03-02-2017
 */
// по дефолту сканит тот же пакет, где лежит данный конфиг
@ComponentScan("by.den.spring.screensaver")

@Configuration
public class FrameJavaConfig {

    private Random random = new Random();

    @Bean
    @Scope("prototype")
    public Color color3rd() {
        return new Color(
                random.nextInt(255),
                random.nextInt(255),
                random.nextInt(255));
    }
    @Bean
    public Supplier<Color> colorSupplier() {
        return this::color3rd;
    }
    @Bean
    public ColorFrame3rd frame3rd() {
        return new ColorFrame3rd();
    }

    @Bean
//    @Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
//    @Scope(value = "prototype")
    @Scope(value = "periodical")
    public Color color2nd() {
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

    @Bean
    public TrueColorFrame2nd frame2nd() {
        return new TrueColorFrame2nd() {
            @Override
            protected Color getColor() {
                // это не вызов метода color(), а обращение к бину "color"
                return color2nd();
                // а сам Override-эд метод getColor() -- каждый раз будет
                // возвращать новый бин "color", т.к. он указан как prototype.
            }
        };
    }

}
