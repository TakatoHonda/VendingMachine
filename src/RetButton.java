import javax.swing.JButton;


@SuppressWarnings("serial")
public class RetButton extends JButton{
	RetButton(int x, int y){
		this.setBounds(x, y, 40, 21);
		this.setText("RET");
	}
}
