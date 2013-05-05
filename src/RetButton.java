import javax.swing.ImageIcon;
import javax.swing.JButton;


@SuppressWarnings("serial")
public class RetButton extends JButton{
	ImageIcon icon = new ImageIcon("../img/retIcon.png");
	int x=435, y=180;
	RetButton(){
		this.setBounds(x, y, 40, 21);
		this.setIcon(icon);
	}
}
