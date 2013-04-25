import javax.swing.ImageIcon;
import javax.swing.JButton;


@SuppressWarnings("serial")
public class StationButton extends JButton{
	private String name;
	private int   price;
			
	StationButton(String name, int price, int x, int y){
		this.setEnabled(false);
		this.name  = name;
		this.price = price;
		this.setBounds(x,y,30,30);
		//if(price!=0){this.setText(""+price);}
	}
	
	//Setter
	public void setButtonLight(ImageIcon icon){
		this.setEnabled(true);
		this.setIcon(icon);
	}
	
	//Getter
	@Override
	public String getName(){return name;}
	public int getPrice(){return  price;}
	 
}
