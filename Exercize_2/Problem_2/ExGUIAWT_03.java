import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class ExGUIAWT_03 extends ExGUIAWT_02 implements MouseListener {
    
    public ExGUIAWT_03() {
        super();
        
        // Register mouse listener to the parent class's canvas object
        canvas.addMouseListener(this);
        
        // Update the frame title
        setTitle("ExGUIAWT_03: AWT Drawing with Mouse Control");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Get mouse coordinates from the event
        int x = e.getX();
        int y = e.getY();
        
        // Save coordinates to parent class's center coordinate variables
        centerX = x;
        centerY = y;
        
        // Repaint the canvas to update the screen
        canvas.repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Empty implementation
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Empty implementation
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Empty implementation
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Empty implementation
    }

    public static void main(String[] args) {
        new ExGUIAWT_03();
    }
}
