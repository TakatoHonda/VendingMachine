package window.confirmWindow.button;

import gui.VendingMachineGUI;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import window.confirmWindow.ConfirmWindow;

@SuppressWarnings("serial")
public class CancelButton extends JButton implements MouseListener{
	private  VendingMachineGUI gui;
	private  ConfirmWindow confirmWindow;
	ImageIcon CancelButIcon = new ImageIcon("./img/cancel-button.png");
	public CancelButton(VendingMachineGUI gui, ConfirmWindow confirmWindow){
		this.gui = gui;
		this.confirmWindow = confirmWindow;
		setBounds(140, 90, 140, 60);
		//setIcon(CancelButIcon);
		setText("Cancel");
		setForeground(Color.white);
		setContentAreaFilled(false);
		//setBorderPainted(false);
		addMouseListener(this);
		
	}
	public void mouseClicked(MouseEvent e) {
		confirmWindow.setVisible(false);
		gui.setEnabled(true);
		gui.paint(getGraphics());
		}

	public void mouseEntered(MouseEvent e) {
		System.out.println("entered!");
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

}
