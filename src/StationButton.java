import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class StationButton extends JButton implements MouseListener{
	private String name;
	private int price;
	private CoinCounter coinCounter;
	private ConfirmWindow CFW;
	ImageIcon buttonLight = new ImageIcon("./img/stationIcon.gif");
	private String route;
	StationButton(String name, int price, int x, int y, CoinCounter coinCounter, String route) {
		this.setEnabled(false);
		this.name = name;
		this.price = price;
		this.coinCounter = coinCounter;
		this.route = route;
		this.setBounds(x, y, 30, 30);
		this.setIcon(buttonLight);
	}

	public void setEnabled() {
		if (this.price <= coinCounter.getAmount()) {
			this.setEnabled(true);
			addMouseListener(this);
		} else {
			this.setEnabled(false);
			removeMouseListener(this);
		}
	}

	public void setDoublePrice(boolean isRoundTrip) {
		if (isRoundTrip) {
			this.price *= 2;
		} else {
			this.price /= 2;
		}
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}
	public void mouseClicked(MouseEvent e){
		try{
		CFW = new ConfirmWindow(name, "time", price, route);
		CFW.setVisible(true);
		}catch(Exception e1){
			System.out.println("Error in mouseClicked().");
		}
	}
	public void mouseEntered(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	

}
