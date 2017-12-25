package by.den.spring.screensaver.frame;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public abstract class Frame2AbstractMethod extends JFrame {

    private static final Random RANDOM = new Random();

    public Frame2AbstractMethod() {
        setSize(200, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void showOnRandomPlace() {
        setLocation(RANDOM.nextInt(1200), RANDOM.nextInt(800));
        getContentPane().setBackground(getColor());
        repaint();
    }

    protected abstract Color getColor();

}
