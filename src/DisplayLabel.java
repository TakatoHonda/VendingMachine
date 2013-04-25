import javax.swing.JLabel;


public class DisplayLabel extends JLabel{
	private String disp_name;
	DisplayLabel(String disp_name, int x, int y){
		this.disp_name = disp_name;
		this.setBounds(x, y, 55, 20);
		this.setText(disp_name);
	}
}
