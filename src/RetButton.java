import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class RetButton extends JButton implements MouseListener {
	
	private ImageIcon icon = new ImageIcon("./img/retIcon.png");
	private int x = 430, y = 180;
	private DispAmount dispInput;
	private CoinCounter coinCounter;
	private NoCoinLight no50Light;
	private NoCoinLight no100Light;
	private StationButton[] stations;
	private VendingMachine vm;
	RetButton(CoinCounter coinCounter, DispAmount dispValue, NoCoinLight no50Light, NoCoinLight no100Light, StationButton[] stations, VendingMachine vm) {
		this.setBounds(x, y, 40, 21);
		this.setIcon(icon);
		this.coinCounter = coinCounter;
		this.dispInput = dispValue;
		this.no50Light = no50Light;
		this.no100Light = no100Light;
		this.stations = stations;
		this.vm = vm;
		addMouseListener(this);
		
	}

	public void mouseClicked(MouseEvent e) {
		coinCounter.clear();// Initial
		vm.ioRET();
		no50Light.changeColor();
		no100Light.changeColor();
		dispInput.setAmount(0);
		for(int i=0;i<stations.length;i++){
			stations[i].setButtonState();
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