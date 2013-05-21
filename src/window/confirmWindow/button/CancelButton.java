package window.confirmWindow.button;

import gui.VendGui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import window.confirmWindow.ConfirmWindow;

@SuppressWarnings("serial")
public class CancelButton extends JButton implements MouseListener{
	private  VendGui gui;
	private  ConfirmWindow confirmWindow;
	ImageIcon CancelButIcon = new ImageIcon("./img/cancel-button.png");
	public CancelButton(VendGui gui, ConfirmWindow confirmWindow){
		this.gui = gui;
		this.confirmWindow = confirmWindow;
		setBounds(170, 90, 30, 30);
		setIcon(CancelButIcon);
		setContentAreaFilled(false);
		setBorderPainted(false);
		addMouseListener(this);
		
	}
	public void mouseClicked(MouseEvent e) {
		confirmWindow.setVisible(false);
		gui.setEnabled(true);
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
