import javax.swing.JTextField;


@SuppressWarnings("serial")
public class DispAmount extends JTextField{
	private int disp_val;
	
	DispAmount(int x,int y){
		this.disp_val = 0;
		this.setBounds(x,y,80,20);
		this.setText(""+disp_val);
		this.setEditable(false);
		this.setHorizontalAlignment(RIGHT);
	}
}
