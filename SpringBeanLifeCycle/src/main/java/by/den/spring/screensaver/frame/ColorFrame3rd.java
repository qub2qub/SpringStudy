package by.den.spring.screensaver.frame;

import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.function.Supplier;

/**
 * Created by Denis on 03-02-2017
 */
public class ColorFrame3rd extends JFrame {

    @Autowired
    private Supplier<Color> colorSupplier;

    public ColorFrame3rd() {
        setSize(200, 200);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void showOnRandomPlace() {
        Random random = new Random();
        setLocation(random.nextInt(1200), random.nextInt(800));
        Color color = colorSupplier.get();
        System.out.println("color = " + color);
        getContentPane().setBackground(color);
        repaint();
    }

}
