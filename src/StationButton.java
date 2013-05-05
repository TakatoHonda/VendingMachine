import javax.swing.ImageIcon;
import javax.swing.JButton;


@SuppressWarnings("serial")
public class StationButton extends JButton{
	private String name;
	private int   price;
	private CoinCounter coinCounter;
	ImageIcon buttonLight = new ImageIcon("../img/yellow.jpg");
	StationButton(String name, int price, int x, int y, CoinCounter coinCounter){
		this.setEnabled(false);
		this.name  = name;
		this.price = price;
		this.coinCounter = coinCounter;
		this.setBounds(x,y,30,30);
		this.setIcon(buttonLight);
	}
	
	public void setButtonLight(){
		if(this.price <= coinCounter.getAmount()){
		this.setEnabled(true);
		}else{
			this.setEnabled(false);
		}
	}
	public void setDoublePrice(boolean isRoundTrip){
		if(isRoundTrip){this.price*=2;}
		else{this.price/=2;}
	}
	public String getName(){return name;}
	public int getPrice(){return  price;}
	
}
