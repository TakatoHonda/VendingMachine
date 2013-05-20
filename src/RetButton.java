




import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import machineTest.VendingMachine;

@SuppressWarnings("serial")
public class RetButton extends JButton implements MouseListener {
	
	private ImageIcon icon = new ImageIcon("./img/retIcon.png");
	private int x = 430, y = 180;
	private TransitionStateManager tsManager;
	private VendingMachine vm;
	RetButton(TransitionStateManager tsManager, VendingMachine vm) {
		this.setBounds(x, y, 40, 21);
		this.setIcon(icon);
		this.tsManager = tsManager;
		this.vm = vm;
		addMouseListener(this);
		
	}

	public void mouseClicked(MouseEvent e) {
		vm.ioRET();
		tsManager.retCoins();
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