package Exercize_2;

import java.awt.Button;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExGUIAWT_02 extends ExGUIAWT_01 implements ActionListener {
    private Button increase = new Button("Increase r (r <= 100)");
    private Button decrease = new Button("Decrease r (r >= 10)");

    public ExGUIAWT_02(String input) {
        super(input);
        this.increase = new Button("Increase r (r <= 100)");
        this.decrease = new Button("Decrease r (r >= 10)");
        this.increase.addActionListener(this);
        this.decrease.addActionListener(this);
        Panel panel = new Panel();
        panel.add(this.increase);
        panel.add(this.decrease);
        this.add(panel, "South");
    }

    public static void main(String[] args) {
        new ExGUIAWT_02("ExGUIAWT_02");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.increase) {
            if (this.radius < 100) {
                this.radius++;
            }
        } else if (e.getSource() == this.decrease) {
            if (this.radius > 10) {
                this.radius --;
            }
        }
        this.cvs.repaint();
    }
}
