package by.den.spring.screensaver.frame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.*;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by Denis on 03-02-2017
 */
@org.springframework.stereotype.Component
public class ColorFrame extends JFrame {

    @Autowired
    private Color color;

    public ColorFrame() {
        setSize(200, 200);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void showOnRandomPlace() {
        Random random = new Random();
        setLocation(random.nextInt(1200), random.nextInt(800));
        getContentPane().setBackground(color);
        repaint();
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
