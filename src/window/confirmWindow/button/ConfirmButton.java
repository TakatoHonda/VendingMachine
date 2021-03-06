package window.confirmWindow.button;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import panel.TicketPanel;
import window.alertWindow.AlertWindow;
import window.confirmWindow.ConfirmWindow;
import manager.TransitionStateManager;
import machine.VendingMachine;
import gui.VendingMachineGUI;
import gui.parts.button.StationButton;

public class ConfirmButton extends JButton implements MouseListener{

	ImageIcon conButIcon1 = new ImageIcon("./img/confirm1.png");
	ImageIcon conButIcon2 = new ImageIcon("./img/confirm2.png");

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
		setIcon(conButIcon1);
		setForeground(Color.white);
		setText("Confirm");
		setContentAreaFilled(false);
		setBorderPainted(false);
		addMouseListener(this);
	}

	public void setStation(StationButton station){
		this.station = station;
	}

	@Override
	public void mouseClicked(MouseEvent e){
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
		if (!vm.ioNotSel()){
			for (int i = 0; i < 2; i++){
				if (vm.ioSEL150()){
					System.out.println("get ticket 150");
					TicketPanel ticketFrame = new TicketPanel("150");
					ticketFrame.setVisible(true);
					vm.ioACK();
				}else if (vm.ioSEL200()){
					System.out.println("get ticket 200");
					TicketPanel ticketFrame = new TicketPanel("200");
					ticketFrame.setVisible(true);
					vm.ioACK();
				}else if (vm.ioSEL450()){
					System.out.println("get ticket 450");
					TicketPanel ticketFrame = new TicketPanel("450");
					ticketFrame.setVisible(true);
					vm.ioACK();
				}else{
					AlertWindow alertWindow = new AlertWindow("Cannot sell for cannot return the charge.");
					alertWindow.setVisible(true);
				}
				if (!tsManager.isRoundTrip()){
					break;
				}

			}
			confirmWindow.setVisible(false);
			tsManager.changeNoCoinLight();
			gui.setEnabled(true);
			gui.paint(getGraphics());
			tsManager.retCoins();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e){
		setIcon(conButIcon2);
	}

	@Override
	public void mousePressed(MouseEvent e){}

	@Override
	public void mouseReleased(MouseEvent e){}

	@Override
	public void mouseExited(MouseEvent e){
		setIcon(conButIcon1);
	}

}
