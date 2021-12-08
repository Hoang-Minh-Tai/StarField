import javax.swing.*;
import java.awt.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;

public class StarField extends JPanel implements MouseListener {
    public static final int SIZE = 600;
    Star[] star = new Star[200];
    Timer timer = new Timer();
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            repaint();
        }
    };
    int delay = 5;

    StarField() {
        for (int i = 0; i < star.length; i++) {
            star[i] = new Star();
        }
        setPreferredSize(new Dimension(SIZE,SIZE));
        setBackground(Color.black);
        addMouseListener(this);
        timer.schedule(task,0,delay);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        g.setColor(Color.white);
        for (int i = 0; i < star.length; i++) {
            star[i].update();
            star[i].show(g);
        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        Star.mod1 = !Star.mod1;
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}