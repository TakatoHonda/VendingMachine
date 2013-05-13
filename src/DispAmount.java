import javax.swing.JTextField;


@SuppressWarnings("serial")
public class DispAmount extends JTextField{
	private int dspValue;
	
	DispAmount(int x,int y){
		this.dspValue = 0;
		this.setBounds(x,y,80,20);
		this.setText(Integer.toString(dspValue));
		this.setEditable(false);
		this.setHorizontalAlignment(RIGHT);
	}
	
	public void setAmount(int dispValue){
		this.setText(Integer.toString(dispValue));
		
	}
	public void clear(){
		dspValue = 0;
		this.setText(""+dspValue);
	}
}
