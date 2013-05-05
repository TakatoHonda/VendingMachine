import javax.swing.JLabel;


@SuppressWarnings("serial")
public class DisplayLabel extends JLabel{
	DisplayLabel(String disp_name, int x, int y){
		this.setBounds(x, y, 55, 20);
		this.setText(disp_name);
	}
}
