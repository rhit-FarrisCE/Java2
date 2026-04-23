import javax.swing.JLabel;

public class ExGUISwing_02  extends ExGUISwing_01 implements java.awt.event.ActionListener {

    private boolean powerOn = false;
    private boolean CDSelected = false;
    private boolean AMSelected = false;
    private boolean FMSelected = false;
    private final JLabel label2 = new JLabel("");
    private double amFrequency [] = {530, 540, 550}; 
    private double fmFrequency [] = {87.9, 88.1, 88.3};
    private int amIndex = 0;
    private int fmIndex = 0;
    private int track = 1;


    public ExGUISwing_02() {
        super();
        this.label2.setBounds(10, 10, 50, 20);
        this.label.setBounds(10, 35, 170, 50);
        this.display.add(this.label2);
        this.Repaint();
        this.power.addActionListener(this);
        this.cd.addActionListener(this);
        this.up.addActionListener(this);
        this.down.addActionListener(this);
        this.am.addActionListener(this);
        this.fm.addActionListener(this);
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        Object source = e.getSource();
        if (source == this.power) {
            this.powerOn = !this.powerOn;
            this.CDSelected = false;
            this.track = 1;
        }
        if (source == this.cd) {
            this.CDSelected = true;
            this.powerOn = true;
        }
        if (source == this.am) {
            this.AMSelected = true;
            this.FMSelected = false;
            this.CDSelected = false;
            this.powerOn = true;
        }
        if (source == this.fm) {
            this.FMSelected = true;
            this.AMSelected = false;
            this.CDSelected = false;
            this.powerOn = true;
        }
        if (source == this.up) {
            if(this.CDSelected) {
                if (this.track < 20) {
                    this.track++;
                }
            }
            else if(this.AMSelected) {
                this.amIndex++;
                if (this.amIndex >= this.amFrequency.length) {
                    this.amIndex = this.amFrequency.length - 1;
                }
            }
            else if(this.FMSelected) {
                this.fmIndex++;
                if (this.fmIndex >= this.fmFrequency.length) {
                    this.fmIndex = this.fmFrequency.length - 1;
                }
            }
        }
        if (source == this.down) {
            if (this.CDSelected) {
                if (this.track > 1) {
                    this.track--;
                }
            }
            else if(this.AMSelected) {
                this.amIndex--;
                if (this.amIndex < 0) {
                    this.amIndex = 0;
                }
            }
            else if(this.FMSelected) {
                this.fmIndex--;
                if (this.fmIndex < 0) {
                    this.fmIndex = 0;
                }
            }
        }
        this.Repaint();
    }

    public void Repaint() {
        if (!this.powerOn){
            this.power.setEnabled(false);
            this.up.setEnabled(false);
            this.down.setEnabled(false);
            this.label.setText("Power Off");
            this.label2.setVisible(false);
        } else {
            this.power.setEnabled(true);
            this.label.setText("Power On");
            if (this.CDSelected) {
                this.up.setEnabled(true);
                this.down.setEnabled(true);
                this.label.setText("Track "+this.track+"/20");
                this.label2.setText("CD");
                this.label2.setVisible(true);
            } else if (this.AMSelected) {
                this.up.setEnabled(true);
                this.down.setEnabled(true);
                this.label.setText(this.amFrequency[this.amIndex]+" kHz");
                this.label2.setText("AM");
                this.label2.setVisible(true);
            } else if (this.FMSelected) {
                this.up.setEnabled(true);
                this.down.setEnabled(true);
                this.label.setText(this.fmFrequency[this.fmIndex]+" MHz");
                this.label2.setText("FM");
                this.label2.setVisible(true);
            } else {
                this.up.setEnabled(false);
                this.down.setEnabled(false);
                this.label2.setVisible(false);
            }
        }
    }



    public static void main(String[] args) {
        ExGUISwing_02 ex = new ExGUISwing_02();
        ex.setVisible(true);
    }
    
}
