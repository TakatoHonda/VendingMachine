import javax.swing.JTextField;


@SuppressWarnings("serial")
public class DispAmount extends JTextField{
	private int dispValue;
	
	DispAmount(int x,int y){
		this.dispValue = 0;
		this.setBounds(x,y,80,20);
		this.setText(Integer.toString(dispValue));
		this.setEditable(false);
		this.setHorizontalAlignment(RIGHT);
	}
	
	public void setAmount(int dispValue){
		this.setText(Integer.toString(dispValue));
		
	}
	public void clear(){
		dispValue = 0;
		this.setText(""+dispValue);
	}
}
