


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class RetButton extends JButton implements MouseListener {
	
	private ImageIcon icon = new ImageIcon("./img/retIcon.png");
	private int x = 430, y = 180;
	private TransitionState transitionState;
	private VendingMachine vm;
	RetButton(TransitionState transitionState, VendingMachine vm) {
		this.setBounds(x, y, 40, 21);
		this.setIcon(icon);
		this.transitionState = transitionState;
		this.vm = vm;
		addMouseListener(this);
		
	}

	public void mouseClicked(MouseEvent e) {
		transitionState.clear();// Initial
		vm.ioRET();
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