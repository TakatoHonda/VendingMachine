import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class CoinButton extends JButton implements MouseListener {
	private int value;
	private CoinCounter coinCounter;
	private StationButton stations[];
	private DispAmount dspInput;
	private VendingMachine vm;
	private AlertWindow alertWindow;

	CoinButton(int value, int x, int y, ImageIcon icon, CoinCounter coinCounter, StationButton[] stations, DispAmount dspValue, VendingMachine vm) {
		this.coinCounter = coinCounter;
		this.value = value;
		this.dspInput = dspValue;
		this.stations = stations;
		this.vm = vm;
		this.setBounds(x, y, 40, 40);
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);
		this.setIcon(icon);
		addMouseListener(this);
	}

	public int getValue() {
		return value;
	}

	public void mouseClicked(MouseEvent e) {
		try{
		if (vm.ioIOVR() || vm.ioSOVR()) {
			String s;
			if (vm.ioIOVR()){s = "over 1000yen";}
			else{s = "over 10coins";}
			System.out.println("error: " + s);
			vm.ioACK();
			alertWindow = new AlertWindow(s);
			alertWindow.setVisible(true);
		} else {
			switch (value) {
			case 50:
				vm.ioC50();
				vm.ioSTB();
				break;
			case 100:
				vm.ioC100();
				vm.ioSTB();
				break;
			case 500:
				vm.ioC500();
				vm.ioSTB();
				break;
			default:
				System.out.println("error in class CoinButton");

			}
			coinCounter.setCoin(value);
			dspInput.setAmount(coinCounter.getAmount());
			for (int i = 0; i < stations.length; i++) {
				stations[i].setButtonState();
			}
		}
		}catch(Exception e1){
			System.out.println("error in mouseclicked()");
		}
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}
}
