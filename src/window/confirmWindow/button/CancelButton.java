package window.confirmWindow.button;

import gui.VendingMachineGUI;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import window.confirmWindow.ConfirmWindow;

public class CancelButton extends JButton implements MouseListener{
	private  VendingMachineGUI gui;
	private  ConfirmWindow confirmWindow;
	ImageIcon CancelButIcon1 = new ImageIcon("./img/cancel1.png");
	ImageIcon CancelButIcon2 = new ImageIcon("./img/cancel2.png");
	public CancelButton(VendingMachineGUI gui, ConfirmWindow confirmWindow){
		this.gui = gui;
		this.confirmWindow = confirmWindow;
		setBounds(140, 90, 140, 60);
		setIcon(CancelButIcon1);
		setForeground(Color.white);
		setContentAreaFilled(false);
		setBorderPainted(false);
		addMouseListener(this);
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		confirmWindow.setVisible(false);
		gui.setEnabled(true);
		gui.paint(getGraphics());
		}

	@Override
	public void mouseEntered(MouseEvent e) {
		setIcon(CancelButIcon2);
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setIcon(CancelButIcon1);
	}

}
