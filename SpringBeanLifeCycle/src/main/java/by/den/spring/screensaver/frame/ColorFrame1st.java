package by.den.spring.screensaver.frame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.*;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by Denis on 03-02-2017
 */
@org.springframework.stereotype.Component("frame1st")
public class ColorFrame1st extends JFrame {

    @Autowired @Qualifier("1st")
    private Color color;

    public ColorFrame1st() {
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
