import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.*;

@SuppressWarnings("serial")
public class RoundTripButton extends JButton implements MouseListener {
	boolean isClickedFlag = false;
	StationLabel[] stLabel;
	StationButton[] station;
	ImageIcon offIcon = new ImageIcon("./img/roundTripIcon_off.png");
	ImageIcon onIcon = new ImageIcon("./img/roundTripIcon_on.png");
	int x = 430, y = 125;

	RoundTripButton(StationLabel[] stLabel, StationButton[] station) {
		this.setBounds(x, y, 40, 50);
		this.stLabel = stLabel;
		this.station = station;
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
		
		for (int i = 0; i < station.length; i++) {
			stLabel[i].setPrice(isClickedFlag);
			//station[i].setDoublePrice(isClickedFlag);
			station[i].setRoundTrip(isClickedFlag);
			station[i].setButtonState();
			if(i==station.length-1){stLabel[i+1].setPrice(isClickedFlag);}
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