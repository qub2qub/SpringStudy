package by.den.spring.screensaver.frame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

@Component("frame1st")
//@Scope(BeanDefinition.SCOPE_PROTOTYPE) // будет много разных фреймов всесто 1
public class Frame1Simple extends JFrame {

    private static final Random RANDOM = new Random();

    @Autowired @Qualifier("color1st")
    private Color color;

    public Frame1Simple() {
        setSize(200, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void showOnRandomPlace() {
        setLocation(RANDOM.nextInt(1200), RANDOM.nextInt(800));
        getContentPane().setBackground(color);
        repaint();
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
