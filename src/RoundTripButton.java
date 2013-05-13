import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.*;

@SuppressWarnings("serial")
public class RoundTripButton extends JButton implements MouseListener {
	boolean isClickedFlag = false;
	StationLabel[] st_lbl;
	StationButton[] stations;
	ImageIcon offIcon = new ImageIcon("./img/roundTripIcon_off.png");
	ImageIcon onIcon = new ImageIcon("./img/roundTripIcon_on.png");
	int x = 430, y = 125;

	RoundTripButton(StationLabel[] st_lbl, StationButton[] stations) {
		this.setBounds(x, y, 40, 50);
		this.st_lbl = st_lbl;
		this.stations = stations;
		this.setIcon(offIcon);
		addMouseListener(this);
	}

	public boolean isClicked() {
		return isClickedFlag;
	}

	public void mouseClicked(MouseEvent e) {
		if (isClickedFlag) {
			isClickedFlag = false;
			this.setIcon(offIcon);
		} else {
			isClickedFlag = true;
			this.setIcon(onIcon);
		}

		for (int i = 0; i < st_lbl.length; i++) {
			st_lbl[i].setPrice(isClickedFlag);
			stations[i].setDoublePrice(isClickedFlag);
			stations[i].setEnabled();
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