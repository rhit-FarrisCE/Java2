import javax.swing.JFrame;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.Font;

public class ExGUISwing_01 extends JFrame {
    private final javax.swing.JPanel display = new javax.swing.JPanel();
    private final javax.swing.JLabel label = new javax.swing.JLabel("Power off");
    private final javax.swing.JButton power = new javax.swing.JButton("Power");
    private final javax.swing.JButton am = new javax.swing.JButton("AM");
    private final javax.swing.JButton fm = new javax.swing.JButton("FM");
    private final javax.swing.JButton cd = new javax.swing.JButton("CD");
    private final javax.swing.JButton up = new javax.swing.JButton("Up");
    private final javax.swing.JButton down = new javax.swing.JButton("Down");

    public ExGUISwing_01() {
        super.setTitle("Car Audio");
        this.setSize(370, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        //Create Buttons here
        this.power.setBounds(2, 2, 70, 30);
        this.am.setBounds(2, 40, 70, 30);
        this.fm.setBounds(2, 78, 70, 30);
        this.cd.setBounds(276, 2, 70, 30);
        this.up.setBounds(276, 40, 70, 30);
        this.down.setBounds(276, 78, 70, 30);
        //Create JPanel with Bevel Border
        this.display.setBounds(74, 2, 200, 106);
        this.display.setBorder(new BevelBorder(1));
        //Create JLabel Here
        this.label.setBounds(25, 50, 170, 40);
        this.label.setFont(new Font("Dialog", 1, 30));
        this.label.setForeground(Color.green);
        //Add items to the window
        this.add(this.power);
        this.add(this.am);
        this.add(this.fm);
        this.add(this.cd);
        this.add(this.up);
        this.add(this.down);
        this.display.add(this.label);
        this.add(this.display);
    }

    public static void main(String[] args) {
        ExGUISwing_01 ex = new ExGUISwing_01();
        ex.setVisible(true);
    }
    
}
