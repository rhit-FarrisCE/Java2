package Exercize_2;

import java.awt.Frame;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class ExGUIAWT_01 extends Frame{
    protected ExGUIAWT_CVS cvs = new ExGUIAWT_CVS();
    protected int radius = 100;
    protected Point center = new Point(200, 100);

    public ExGUIAWT_01(String input) {
        super(input);
        this.setVisible(true);
        System.out.println("Default layout manager of Frame: " + this.getLayout());
        this.add(this.cvs, "Center");
        this.setSize(420, 300);
    }
    public static void main(String[] args) {
        new ExGUIAWT_01("Ex#1: Step 1");
    }

    protected final class ExGUIAWT_CVS extends Canvas {
      public void paint(Graphics g) {
         g.setColor(Color.blue);
         g.drawRect(10, 0, 380, 200);
         g.setColor(Color.red);
         g.drawOval(center.x - radius, center.y - radius, 2 * radius, 2 * radius);
         g.setColor(Color.black);
         g.drawString("The circle:", 140, 90);
         g.drawString(String.format("center = (%d,%d);", center.x, center.y), 160, 110);
         g.drawString("radius = " + radius, 160, 130);
      }
    }
}
