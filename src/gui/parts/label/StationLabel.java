package gui.parts.label;

import java.awt.Color;
import javax.swing.*;

import position.Position;

public class StationLabel extends JLabel{
	private final String stationName;
	private int price;
	public StationLabel(String stationName, int price, Position position){
		this.stationName = stationName;
		this.price = price;
		setBounds(position.x, position.y, 105, 25);
		setText("<html>"+stationName+"<br>"+"<font color=#ffd700>"+price+"</font>"+"</html>");
		setForeground(Color.white);
	}
	public void setPrice(boolean isClicked){
		if(isClicked == true){
			price = price * 2;
			this.setText("<html>"+stationName+"<br>"+"<font color=#ffd700>"+price+"</font>"+"</html>");
		}
		else{
			price = price / 2;
			this.setText("<html>"+stationName+"<br>"+"<font color=#ffd700>"+price+"</font>"+"</html>");
		}
	}
}