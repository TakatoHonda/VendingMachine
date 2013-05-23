package window.confirmWindow.button;

import gui.VendingMachineGUI;
import gui.parts.button.StationButton;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import panel.TicketPanel;
import window.alertWindow.AlertWindow;
import window.confirmWindow.ConfirmWindow;

import machineTest.VendingMachine;
import manager.TransitionStateManager;

public class ConfirmButton extends JButton implements MouseListener{
	
	ImageIcon ConButIcon = new ImageIcon("./img/confirm-button.png");
	private StationButton station;
	private VendingMachine vm;
	private TransitionStateManager tsManager;
	private VendingMachineGUI gui;
	private ConfirmWindow confirmWindow;
	public ConfirmButton(VendingMachine vm, TransitionStateManager tsManager, VendingMachineGUI gui, ConfirmWindow confirmWindow){
		this.vm = vm;
		this.tsManager = tsManager;
		this.gui = gui;
		this.confirmWindow = confirmWindow;
		setBounds(0, 90, 140, 60);
		//setIcon(ConButIcon);
		setForeground(Color.white);
		setText("Confirm");
		setContentAreaFilled(false);
		//setBorderPainted(false);
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
				TicketPanel ticketFrame = new TicketPanel("150");
				ticketFrame.setVisible(true);
			} else if (vm.ioSEL200()){
				System.out.println("get ticket 200");
				TicketPanel ticketFrame = new TicketPanel("200");
				ticketFrame.setVisible(true);
			} else if (vm.ioSEL450()){
				System.out.println("get ticket 450");
				TicketPanel ticketFrame = new TicketPanel("450");
				ticketFrame.setVisible(true);
			}else{
				AlertWindow alertWindow = new AlertWindow("Cannot sell for cannot return the charge.");
				alertWindow.setVisible(true);
			}
			vm.ioACK();
			if(!tsManager.isRoundTrip()){break;}
		}
		tsManager.changeNoCoinLight();
	confirmWindow.setVisible(false);
	gui.setEnabled(true);
	gui.paint(getGraphics());
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
