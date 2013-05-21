



import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class StationButton extends JButton implements MouseListener{
	ImageIcon buttonLight = new ImageIcon("./img/stationIcon.gif");
	private String name;
	private String route;
	private int    price;
	private ConfirmWindow confirmWindow;
	public StationButton(String name, int price, String route, int x, int y){
		this.setEnabled(false);
		this.name = name;
		this.price = price;
		this.route = route;
		this.setBounds(x, y, 30, 30);
		this.setIcon(buttonLight);
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
	}
	public void mouseClicked(MouseEvent e){
			confirmWindow.setVisible(this);
	}

	public void mouseEntered(MouseEvent e){
	}

	public void mousePressed(MouseEvent e){
	}

	public void mouseReleased(MouseEvent e){
	}

	public void mouseExited(MouseEvent e){
	}

}
