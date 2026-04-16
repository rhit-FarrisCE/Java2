import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

/**
 * Animation using AWT, Thread and double buffering
 * @author sxxxxxxx (Your student ID)
 */
public class ExAWTAnimation extends Frame implements Runnable{
    //== Parameters of the animation figure ===================
    protected int radius = 10;
    protected Point center = new Point(200, 100);

    //=========================================================
    // Image data for double buffering
    private final BufferedImage buffer = new BufferedImage(420, 300, BufferedImage.TYPE_INT_BGR);
    // The canvas object to show animation figure on the window
    private final Animation_CVS cvs = new Animation_CVS();

    // An inner canvas class 
    private final class Animation_CVS extends Canvas {
        // Method paint() will be automatically invoked when needed
        // paint() is for creating one frame of the animation
        @Override
        public void paint(final Graphics gCanvas){
            // Get the Graphics of the buffer
            Graphics gBuffer = buffer.getGraphics();
            // Clear the buffer by white color
            gBuffer.setColor(Color.white);
            gBuffer.fillRect(0, 0, 420, 300);

            //=========================================================
            // Use gBuffer to draw the figure on the buffer
            // (The parameters in the attributes should be used here)
            gBuffer.setColor(Color.red);
            gBuffer.drawOval(ExAWTAnimation.this.center.x - ExAWTAnimation.this.radius, ExAWTAnimation.this.center.y - ExAWTAnimation.this.radius, 2 * ExAWTAnimation.this.radius, 2 * ExAWTAnimation.this.radius);
            gBuffer.setColor(Color.black);
            gBuffer.drawString("The circle:", 140, 90);
            gBuffer.drawString(String.format("center = (%d,%d);", ExAWTAnimation.this.center.x, ExAWTAnimation.this.center.y), 160, 110);
            gBuffer.drawString("radius = " + ExAWTAnimation.this.radius, 160, 130);
            gCanvas.drawImage(ExAWTAnimation.this.buffer, 0, 0, (ImageObserver)null);
            //=========================================================
            // Copy the buffer to the canvas
            gCanvas.drawImage(buffer, 0, 0, null);
        }
    }

    // Method run() is required since your Frame class declares to implement Runnable interface
    // We use run() to control the drawing on the canvas.
    @Override
    public void run(){
        try {
            // Repeat following:
            while(true){
                // Sleep for 0.1 second
                Thread.sleep(100);
                //=========================================================
                // Change the parameters of the animation figure for next frame of the animation
                ++this.radius;
                if (this.radius >= 100) {
                    this.radius = 10;
                }

                //=========================================================

                // This is to invoke the paint() method of the canvas object to draw next frame
                cvs.repaint();
            }
        } catch (Exception ex) {
        }
    }
    /**
     * Constructor
     * @param title the title of the window
     */
    public ExAWTAnimation(String title){
        super(title);
        
        add(cvs);
        setSize(420,300);
        new Thread(this).start();
    }
    public static void main(String[] args){
        new ExAWTAnimation("Ex#2: Step 1").setVisible(true);
    }
}
