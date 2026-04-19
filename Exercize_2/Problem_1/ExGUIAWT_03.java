package Exercize_2.Problem_1;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ExGUIAWT_03  extends ExGUIAWT_02 implements MouseListener {
    public ExGUIAWT_03(String input) {
        super(input);
        cvs.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point p = e.getPoint();
        this.center = p;
        this.cvs.repaint();
    }

    public static void main(String[] args) {
        new ExGUIAWT_03("ExGUIAWT_03");
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
