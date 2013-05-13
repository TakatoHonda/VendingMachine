import javax.swing.*;

@SuppressWarnings("serial")
public class StationLabel extends JLabel{
	private String sta_name;
	private int price;
	StationLabel(String sta_name, int x, int y, int price){
		this.sta_name = sta_name;
		this.price = price;
		this.setBounds(x, y, 105, 25);
		this.setText("<html>"+sta_name+"<br>"+price+"</html>");
		
	}
	public void setPrice(boolean isClicked){
		if(isClicked == true){
			price = price * 2;
			this.setText("<html>"+sta_name+"<br>"+price+"</html>");
		}
		else{
			price = price / 2;
			this.setText("<html>"+sta_name+"<br>"+price+"</html>");
		}
	}
}