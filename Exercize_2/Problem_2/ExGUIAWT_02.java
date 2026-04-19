import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExGUIAWT_02 extends ExGUIAWT_01 implements ActionListener {
    protected Button increaseButton;
    protected Button decreaseButton;

    public ExGUIAWT_02() {
        super();
        
        // Create buttons
        increaseButton = new Button("Increase Radius");
        decreaseButton = new Button("Decrease Radius");
        
        // Create panel for buttons
        Panel buttonPanel = new Panel();
        buttonPanel.add(increaseButton);
        buttonPanel.add(decreaseButton);
        
        // Add button panel to BorderLayout.SOUTH
        add(buttonPanel, BorderLayout.SOUTH);
        
        // Register action listeners for both buttons
        increaseButton.addActionListener(this);
        decreaseButton.addActionListener(this);
        
        // Update the frame
        setTitle("ExGUIAWT_02: AWT Drawing with Buttons");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Check which button was pressed using getSource()
        if (e.getSource() == increaseButton) {
            // Increase radius, but keep it between 10 and 100
            if (radius < 100) {
                radius += 10;
            }
        } else if (e.getSource() == decreaseButton) {
            // Decrease radius, but keep it between 10 and 100
            if (radius > 10) {
                radius -= 10;
            }
        }
        
        // Repaint the canvas to update the screen
        canvas.repaint();
    }

    public static void main(String[] args) {
        new ExGUIAWT_02();
    }
}
