package gui.parts.button;



import gui.parts.label.StationLabel;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import manager.TransitionStateManager;



import java.awt.event.*;

@SuppressWarnings("serial")
public class RoundTripButton extends JButton implements MouseListener {
	boolean isRoundTrip = false;
	StationLabel[] stLabel;
	StationButton[] station;
	TransitionStateManager tsManager;
	ImageIcon offIcon = new ImageIcon("./img/roundTripIcon_off.png");
	ImageIcon onIcon = new ImageIcon("./img/roundTripIcon_on.png");
	int x = 430, y = 125;

	public RoundTripButton(TransitionStateManager tsManager) {
		this.setBounds(x, y, 40, 50);
		this.tsManager = tsManager;
		this.setIcon(offIcon);
		addMouseListener(this);
	}

	public boolean isClicked() {
		return isRoundTrip;
	}

	public void mouseClicked(MouseEvent e) {
		if (isRoundTrip) {
			isRoundTrip = false;
			this.setIcon(offIcon);
		} else {
			isRoundTrip = true;
			this.setIcon(onIcon);
		}
		tsManager.setRoundTrip(isRoundTrip);		
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