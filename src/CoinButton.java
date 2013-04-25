import javax.swing.ImageIcon;
import javax.swing.JButton;


@SuppressWarnings("serial")
public class CoinButton extends JButton{
private int value;

	CoinButton(int value, int x, int y, ImageIcon icon){
		this.value = value;
		this.setBounds(x, y, 40,40);
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);
		this.setIcon(icon);
	}
	public int getValue(){return value;}
}
