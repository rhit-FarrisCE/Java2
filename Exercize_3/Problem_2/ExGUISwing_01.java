package Exercize_3.Problem_2;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.Font;

public class ExGUISwing_01 extends JFrame {
    // Protected components so child class can access them
    protected JPanel displayPanel = new JPanel();
    protected JLabel frequencyLabel = new JLabel("FM 88.1 MHz");
    protected JButton powerButton = new JButton("Power");
    protected JButton volPlusButton = new JButton("Vol +");
    protected JButton volMinusButton = new JButton("Vol -");
    protected JButton prevButton = new JButton("Prev");
    protected JButton nextButton = new JButton("Next");
    protected JButton modeButton = new JButton("Mode");

    public ExGUISwing_01() {
        super();
        this.setTitle("Car Audio Control Panel");
        this.setSize(500, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        // Configure left column buttons
        this.powerButton.setBounds(10, 20, 80, 40);
        this.volPlusButton.setBounds(10, 70, 80, 40);
        this.volMinusButton.setBounds(10, 120, 80, 40);

        // Configure right column buttons
        this.prevButton.setBounds(410, 20, 80, 40);
        this.nextButton.setBounds(410, 70, 80, 40);
        this.modeButton.setBounds(410, 120, 80, 40);

        // Configure display panel with BevelBorder (centered)
        this.displayPanel.setBounds(105, 20, 280, 140);
        this.displayPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
        this.displayPanel.setLayout(null);

        // Configure frequency label
        this.frequencyLabel.setBounds(10, 30, 260, 50);
        this.frequencyLabel.setFont(new Font("Arial", Font.BOLD, 24));
        this.frequencyLabel.setForeground(new Color(0, 100, 0)); // Dark green

        // Add components to window
        this.add(this.powerButton);
        this.add(this.volPlusButton);
        this.add(this.volMinusButton);
        this.add(this.prevButton);
        this.add(this.nextButton);
        this.add(this.modeButton);
        this.add(this.displayPanel);

        // Add label to display panel
        this.displayPanel.add(this.frequencyLabel);
    }

    public static void main(String[] argv) {
        ExGUISwing_01 audioPanel = new ExGUISwing_01();
        audioPanel.setVisible(true);
    }
}
