import java.awt.Canvas;
import java.util.ArrayList;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Point;

/**
 * @author sxxxxxxx (Your student ID)
 */
public class ExGenerics_01 extends Frame{
	ArrayList num_list = new ArrayList();
	private final CVS cvs = new CVS();

	// An inner canvas class 
	private final class CVS extends Canvas {
		@Override
		public void paint(final Graphics g){
			super.paint(g);

			for(int ii = 0 ; ii < num_list.size() ; ii++){
				String s = (String)num_list.get(ii);
				g.drawString(s, 100, ii*20);
			}
		}
	}
	/**
	* Constructor
	* @param title the title of the window
	*/
	public ExGenerics_01(String title){
		super(title);

		add(cvs);
		setSize(420,300);
		num_list.add("1200");
		num_list.add(new Point(300, 100));
		num_list.add(1300);
		num_list.add("1400");
		num_list.add("1500");
		num_list.add("1600");
	}
	public static void main(String[] args){
		new ExGenerics_01("ExGenerics_01").setVisible(true);
	}
}
