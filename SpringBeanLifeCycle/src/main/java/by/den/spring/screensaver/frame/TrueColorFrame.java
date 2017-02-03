package by.den.spring.screensaver.frame;

import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by Denis on 03-02-2017
 */
public abstract class TrueColorFrame extends JFrame {

    public TrueColorFrame() {
        setSize(200, 200);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void showOnRandomPlace() {
        Random random = new Random();
        setLocation(random.nextInt(1200), random.nextInt(800));
        getContentPane().setBackground(getColor());
        repaint();
    }

    protected abstract Color getColor();

}
