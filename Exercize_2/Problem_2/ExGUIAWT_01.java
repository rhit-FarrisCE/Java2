import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ExGUIAWT_01 extends Frame {
    protected int radius;
    protected int centerX;
    protected int centerY;
    protected DrawingCanvas canvas;

    public ExGUIAWT_01() {
        // Set window title
        setTitle("AWT Drawing Program");
        
        // Set window size to 400 x 300
        setSize(400, 300);
        
        // Initialize circle parameters
        radius = 100;
        centerX = 200;
        centerY = 100;
        
        // Create the canvas object
        canvas = new DrawingCanvas();
        
        // Use BorderLayout and add canvas to CENTER
        setLayout(new BorderLayout());
        add(canvas, BorderLayout.CENTER);
        
        // Add window close listener
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        
        // Display the frame
        setVisible(true);
    }

    // Inner class to draw shapes
    protected class DrawingCanvas extends Canvas {
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            
            // Draw blue rectangle
            g.setColor(Color.BLUE);
            g.drawRect(10, 0, 380, 200);
            
            // Draw red circle
            g.setColor(Color.RED);
            g.drawOval(centerX - radius, centerY - radius, radius * 2, radius * 2);
            
            // Output circle parameters as text
            g.setColor(Color.BLACK);
            g.drawString("The circle:", 140, 90);
            g.drawString(String.format("center = (%d,%d);", centerX, centerY), 160, 110);
            g.drawString("radius = " + radius, 160, 130);
        }
    }

    public static void main(String[] args) {
        new ExGUIAWT_01();
    }
}
