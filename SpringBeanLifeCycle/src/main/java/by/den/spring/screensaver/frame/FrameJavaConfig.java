package by.den.spring.screensaver.frame;

import by.den.spring.screensaver.periodical.CustomPeriodicalScopeConfigurer;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;

import java.awt.*;
import java.util.Random;
import java.util.function.Supplier;

@Configuration
// по дефолту сканит тот же пакет, где лежит данный конфиг
@ComponentScan("by.den.spring.screensaver")
public class FrameJavaConfig {
    
    private static final Random RANDOM = new Random();
    
    private static Color getRandomColor() {
        return new Color(
            RANDOM.nextInt(255),
            RANDOM.nextInt(255),
            RANDOM.nextInt(255));
    }
    
    @Bean
//    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    //  При proxyMode каждый раз при обращении к переменной color во frame будет создаваться новый объект
//    @Scope(value = BeanDefinition.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public Color color1st() {
        return getRandomColor();
    }
    
    @Bean
//    @Qualifier("color1st")
    @Scope(CustomPeriodicalScopeConfigurer.PERIODICAL)
    public Color color2nd() {
        return getRandomColor();
    }
    
    @Bean
    public Frame2AbstractMethod frame2nd() {
        return new Frame2AbstractMethod() {
            @Override
            protected Color getColor() {
                // это не вызов метода color2nd(), а обращение к бину "color2nd"
                return color2nd();
                // а сам Override-эд метод getColor() -- каждый раз будет
                // возвращать новый бин "color2nd", т.к. он указан как prototype.
            }
        };
    }
    
    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Color color3rd() {
        return getRandomColor();
    }
    
    @Bean
    public Supplier<Color> colorSupplier() {
        return this::color3rd;
    }
    
    @Bean
    public Frame3Supplier frame3rd() {
        return new Frame3Supplier();
    }
    
}
