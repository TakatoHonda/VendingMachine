package window.confirmWindow;

import gui.VendingMachineGUI;
import gui.parts.button.StationButton;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import window.confirmWindow.button.CancelButton;
import window.confirmWindow.button.ConfirmButton;


import machineTest.VendingMachine;
import manager.TransitionStateManager;




@SuppressWarnings("serial")
public class ConfirmWindow extends JFrame{
	ImageIcon ConBKGD = new ImageIcon("./img/ConBKGD.jpg");
	private ReadTimeTable timeTable = new ReadTimeTable();
	private VendingMachine vm;
	private JLabel stationNameLabel;
	private JLabel priceLabel;
	private JLabel leaveTimeLabel;
	private JLabel tripLabel;
	private VendingMachineGUI gui;
	private TransitionStateManager tsManager;
	private ConfirmButton confirmButton;
	private CancelButton cancelButton;
	
	
	public ConfirmWindow(VendingMachineGUI gui, final VendingMachine vm, TransitionStateManager tsManager){
		this.gui = gui;
		this.vm = vm;
		this.tsManager = tsManager;
		setSize(280, 150);
		setLocation(100, 75);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setAlwaysOnTop(true);
		setResizable(false);
		setUndecorated(true);
		setLayout(null);
		stationNameLabel = new JLabel();
		stationNameLabel.setBounds(50, 10, 200, 10);
		stationNameLabel.setForeground(Color.black);
		add(stationNameLabel);

		priceLabel = new JLabel();
		priceLabel.setBounds(70, 30, 150, 10);
		priceLabel.setForeground(Color.black);
		add(priceLabel);

		
		leaveTimeLabel = new JLabel();
		leaveTimeLabel.setBounds(50, 50, 200, 10);
		leaveTimeLabel.setForeground(Color.black);
		add(leaveTimeLabel);
		
		tripLabel = new JLabel();
		tripLabel.setBounds(100, 70, 200, 15);
		add(tripLabel);

		confirmButton = new ConfirmButton(vm, tsManager, gui, this);
		add(confirmButton);
		cancelButton = new CancelButton(gui, this);
		add(cancelButton);
		
	}
	public void setVisible(final StationButton station){
	// Set confirmWindow property
		setTitle("Go to " + station.getName());
		setVisible(true);
		
		// stationNameLabel
		stationNameLabel.setText("Ticket to " + station.getName() + ".");
		
		// priceLabel
		priceLabel.setText("The Price is " + station.getPrice() + ".");
		
		// leaveTimeLabel
		leaveTimeLabel.setText("Next departure time: " + timeTable.getLeaveTime(station.getRoute()));
		// RoundTrip or Single-trip label
		if (tsManager.isRoundTrip()){
			tripLabel.setText("Round trip!");
		} else{
			tripLabel.setText("Single trip!");
		}
		confirmButton.setStation(station);
		
		// Set background
		// ***************************************************************************************
		JLabel label = new JLabel(ConBKGD);
		label.setBounds(0, 0, ConBKGD.getIconWidth(), ConBKGD.getIconHeight());
		JPanel imagePanel = (JPanel) this.getContentPane();
		imagePanel.setOpaque(false);

		this.getLayeredPane().setLayout(null);
		this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(ConBKGD.getIconWidth(), ConBKGD.getIconHeight());
		this.setVisible(true);
		// ***************************************************************************************
	}

}
