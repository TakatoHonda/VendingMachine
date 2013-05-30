package gui.parts.button;





import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import machine.VendingMachine;
import manager.TransitionStateManager;

public class RetButton extends JButton implements MouseListener {
	
	private ImageIcon icon0 = new ImageIcon("./img/retIcon0.png");
	private ImageIcon icon1 = new ImageIcon("./img/retIcon1.png");
	private int x = 430, y = 180;	
	private TransitionStateManager tsManager;
	private VendingMachine vm;
	public RetButton(TransitionStateManager tsManager, VendingMachine vm) {
		this.setBounds(x, y, 40, 21);
		this.setIcon(icon0);
		this.tsManager = tsManager;
		this.vm = vm;
		addMouseListener(this);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		vm.ioRET();
		tsManager.retCoins();
		}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		setIcon(icon1);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		setIcon(icon0);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setIcon(icon0);
	}

}