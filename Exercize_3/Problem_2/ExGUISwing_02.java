package Exercize_3.Problem_2;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class ExGUISwing_02 extends ExGUISwing_01 implements java.awt.event.ActionListener {
    // State variables
    private boolean powerOn = false;
    private boolean isFMMode = true;
    private double fmFrequency = 88.1;
    private int amFrequency = 530;
    
    // Band label to display AM/FM
    private JLabel bandLabel = new JLabel("FM");

    public ExGUISwing_02() {
        super();
        
        // Configure band label
        this.bandLabel.setBounds(10, 10, 50, 20);
        this.bandLabel.setFont(new Font("Arial", Font.BOLD, 14));
        this.bandLabel.setForeground(new Color(0, 100, 0)); // Dark green
        this.displayPanel.add(this.bandLabel);

        // Add action listeners to all buttons
        this.powerButton.addActionListener(this);
        this.volPlusButton.addActionListener(this);
        this.volMinusButton.addActionListener(this);
        this.prevButton.addActionListener(this);
        this.nextButton.addActionListener(this);
        this.modeButton.addActionListener(this);

        // Set initial state
        this.updateDisplay();
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        Object source = e.getSource();

        if (source == this.powerButton) {
            this.powerOn = !this.powerOn;
            this.updateDisplay();
        } else if (source == this.modeButton) {
            if (this.powerOn) {
                this.isFMMode = !this.isFMMode;
                this.updateDisplay();
            }
        } else if (source == this.prevButton) {
            if (this.powerOn) {
                if (this.isFMMode) {
                    if (this.fmFrequency > 88.0) {
                        this.fmFrequency -= 0.1;
                        this.fmFrequency = Math.round(this.fmFrequency * 10.0) / 10.0;
                    }
                } else {
                    if (this.amFrequency > 530) {
                        this.amFrequency -= 10;
                    }
                }
                this.updateDisplay();
            }
        } else if (source == this.nextButton) {
            if (this.powerOn) {
                if (this.isFMMode) {
                    if (this.fmFrequency < 108.0) {
                        this.fmFrequency += 0.1;
                        this.fmFrequency = Math.round(this.fmFrequency * 10.0) / 10.0;
                    }
                } else {
                    if (this.amFrequency < 1600) {
                        this.amFrequency += 10;
                    }
                }
                this.updateDisplay();
            }
        } else if (source == this.volPlusButton) {
            if (this.powerOn) {
                this.frequencyLabel.setText("Volume UP");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                this.updateDisplay();
            }
        } else if (source == this.volMinusButton) {
            if (this.powerOn) {
                this.frequencyLabel.setText("Volume DOWN");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                this.updateDisplay();
            }
        }
    }

    private void updateDisplay() {
        if (!this.powerOn) {
            this.frequencyLabel.setText("Power OFF");
            this.bandLabel.setVisible(false);
            this.volPlusButton.setEnabled(false);
            this.volMinusButton.setEnabled(false);
            this.prevButton.setEnabled(false);
            this.nextButton.setEnabled(false);
            this.modeButton.setEnabled(false);
        } else {
            this.volPlusButton.setEnabled(true);
            this.volMinusButton.setEnabled(true);
            this.prevButton.setEnabled(true);
            this.nextButton.setEnabled(true);
            this.modeButton.setEnabled(true);
            this.bandLabel.setVisible(true);

            if (this.isFMMode) {
                this.bandLabel.setText("FM");
                this.frequencyLabel.setText(String.format("%.1f MHz", this.fmFrequency));
            } else {
                this.bandLabel.setText("AM");
                this.frequencyLabel.setText(this.amFrequency + " kHz");
            }
        }
    }

    public static void main(String[] argv) {
        ExGUISwing_02 audioPanel = new ExGUISwing_02();
        audioPanel.setVisible(true);
    }
}
