package window.confirmWindow.button;

import gui.VendGui;
import gui.parts.button.StationButton;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import window.confirmWindow.ConfirmWindow;

import machineTest.VendingMachine;
import manager.TransitionStateManager;

public class ConfirmButton extends JButton implements MouseListener{
	
	ImageIcon ConButIcon = new ImageIcon("./img/confirm-button.png");
	private StationButton station;
	private VendingMachine vm;
	private TransitionStateManager tsManager;
	private VendGui gui;
	private ConfirmWindow confirmWindow;
	public ConfirmButton(VendingMachine vm, TransitionStateManager tsManager, VendGui gui, ConfirmWindow confirmWindow){
		this.vm = vm;
		this.tsManager = tsManager;
		this.gui = gui;
		this.confirmWindow = confirmWindow;
		setBounds(90, 90, 30, 30);
		setIcon(ConButIcon);
		setContentAreaFilled(false);
		setBorderPainted(false);
		addMouseListener(this);
	}
	public void setStation(StationButton station){
		this.station = station;
	}
	public void mouseClicked(MouseEvent e) {
		switch (station.getPrice()){
		case 300:
			vm.ioREQ150();
			System.out.println("Requesut ticket150.");
			break;
		case 150:
			vm.ioREQ150();
			System.out.println("Requesut ticket150.");
			break;
			
		case 400:	
			vm.ioREQ200();
			System.out.println("Requesut ticket200.");
			break;
		case 200:
			vm.ioREQ200();
			System.out.println("Requesut ticket200.");
			break;
			
		case 900:
			vm.ioREQ450();
			System.out.println("Requesut ticket450.");
			break;
		case 450:
			vm.ioREQ450();
			System.out.println("Requesut ticket450.");
			break;
		}
		if (tsManager.isRoundTrip()){
			vm.ioTWICE();
			System.out.println("Request roundtrip ticket.");
		}
		vm.ioSTB();

		// IO in//////////////////////
		for (int i = 0; i < 2; i++){
			if (vm.ioSEL150()){
				System.out.println("get ticket 150");
			} else if (vm.ioSEL200()){
				System.out.println("get ticket 200");
			} else if (vm.ioSEL450()){
				System.out.println("get ticket 450");
			}
			vm.ioACK();
			if(!tsManager.isRoundTrip()){break;}
		}
	confirmWindow.setVisible(false);
	gui.setEnabled(true);
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