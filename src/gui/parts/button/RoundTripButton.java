package gui.parts.button;


import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import gui.parts.label.StationLabel;
import manager.TransitionStateManager;




public class RoundTripButton extends JButton implements MouseListener {
	boolean isRoundTrip = false;
	StationLabel[] stLabel;
	StationButton[] station;
	TransitionStateManager tsManager;
	ImageIcon offIcon = new ImageIcon("./img/roundTripIcon0.png");
	ImageIcon onIcon = new ImageIcon("./img/roundTripIcon1.png");
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

	@Override
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
	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

}