package gui.parts.label;
import java.awt.Color;

import javax.swing.*;

@SuppressWarnings("serial")
public class StationLabel extends JLabel{
	private String sta_name;
	private int price;
	public StationLabel(String sta_name, int x, int y, int price){
		this.sta_name = sta_name;
		this.price = price;
		setBounds(x, y, 105, 25);
		setText("<html>"+sta_name+"<br>"+price+"</html>");
		setForeground(Color.white);
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