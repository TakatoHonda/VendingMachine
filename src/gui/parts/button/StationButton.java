package gui.parts.button;





import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import position.Position;
import window.confirmWindow.ConfirmWindow;

public class StationButton extends JButton implements MouseListener{
	ImageIcon buttonLight = new ImageIcon("./img/stationIcon.png");
	private String name;
	private String route;
	private int    price;
	private ConfirmWindow confirmWindow;
	private Position position;
	public StationButton(String name, int price, String route, Position position){
		this.name = name;
		this.price = price;
		this.route = route;
		this.position =position;
		setBounds(position.x, position.y, 30, 30);
		setIcon(buttonLight);
		setEnabled(false);
	}
	public void setButtonState(int amount){
		if ((price <= amount) && (this.isEnabled() == false)){
			this.setEnabled(true);
			addMouseListener(this);
		} else if ((price > amount) && (this.isEnabled() == true)){
			this.setEnabled(false);
			removeMouseListener(this);
		}
	}
	public void setDoublePrice(boolean isRoundTrip){
		if (isRoundTrip){
			price *= 2;
		} else{
			price /= 2;
		}
	}
	public void setConfirmWindow(ConfirmWindow confirmWindow){
		this.confirmWindow = confirmWindow;
	}
	@Override
	public String getName(){
		return name;
	}
	public int getPrice(){
		return price;
	}
	public String getRoute(){
		return route;
	}
	public void clear(){
		setEnabled(false);
		removeMouseListener(this);
	}
	@Override
	public void mouseClicked(MouseEvent e){
			confirmWindow.setVisible(this);
	}

	@Override
	public void mouseEntered(MouseEvent e){
	}

	@Override
	public void mousePressed(MouseEvent e){
	}

	@Override
	public void mouseReleased(MouseEvent e){
	}

	@Override
	public void mouseExited(MouseEvent e){
	}

}
