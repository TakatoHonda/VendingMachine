import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;


@SuppressWarnings("serial")
public class ResetButton extends JButton{
	ResetButton(int x,int y,ImageIcon color){
		JLabel label = new JLabel("RST");
		this.setIcon(color);//I don't know how to use "setBackground(Color.color)".
							//If I use "setBackground", no change the button's color.
							//Already, I had this idea for change button's color.
		add(label);
		this.setBounds(x, y, 40, 21);
		}

}
