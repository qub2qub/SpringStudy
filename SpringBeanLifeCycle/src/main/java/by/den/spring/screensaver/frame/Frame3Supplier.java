package by.den.spring.screensaver.frame;

import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.function.Supplier;

public class Frame3Supplier extends JFrame {

    private static final Random RANDOM = new Random();

    @Autowired
    private Supplier<Color> colorSupplier;

    public Frame3Supplier() {
        setSize(200, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void showOnRandomPlace() {
        setLocation(RANDOM.nextInt(1200), RANDOM.nextInt(800));
        Color color = colorSupplier.get();
        System.out.println("ColorFrame3rd colorSupplier = " + color);
        getContentPane().setBackground(color);
        repaint();
    }

}
