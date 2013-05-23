package window.confirmWindow;

import gui.VendingMachineGUI;
import gui.parts.button.StationButton;

import java.awt.Color;
import java.awt.Font;
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
		stationNameLabel.setBounds(5, 5, 285, 40);
		stationNameLabel.setForeground(Color.white);
		stationNameLabel.setFont(new Font("ÇlÇr ÉSÉVÉbÉN", Font.BOLD, 35));
		add(stationNameLabel);

		priceLabel = new JLabel();
		priceLabel.setBounds(50, 50, 100, 40);
		priceLabel.setForeground(Color.orange);
		priceLabel.setFont(new Font("ÇlÇr ÉSÉVÉbÉN", Font.BOLD, 40));
		add(priceLabel);

		
		leaveTimeLabel = new JLabel();
		leaveTimeLabel.setBounds(135, 50, 200, 50);
		leaveTimeLabel.setForeground(Color.white);
		leaveTimeLabel.setFont(new Font("ÇlÇr ÉSÉVÉbÉN", Font.BOLD, 25));
		add(leaveTimeLabel);
		
		tripLabel = new JLabel();
		tripLabel.setBounds(5, 60, 200, 40);
		tripLabel.setFont(new Font("ÇlÇr ÉSÉVÉbÉN", Font.BOLD, 10));
		tripLabel.setForeground(Color.white);
		add(tripLabel);

		confirmButton = new ConfirmButton(vm, tsManager, gui, this);
		add(confirmButton);
		cancelButton = new CancelButton(gui, this);
		add(cancelButton);
		
	}
	public void setVisible(final StationButton station){
	// Set confirmWindow property
		setVisible(true);
		gui.setEnabled(false);
		// stationNameLabel
		stationNameLabel.setText(station.getName());
		
		// priceLabel
		priceLabel.setText(""+station.getPrice());
		
		// leaveTimeLabel
		leaveTimeLabel.setText("<html>"+"Next: " + "<font color='#FA8072'>"+timeTable.getLeaveTime(station.getRoute())+"</font></html>");
		// RoundTrip or Single-trip label
		if (tsManager.isRoundTrip()){
			tripLabel.setText(/*"<html><font color='#FA8072'>"+*/"Round="/*+"</font><html>"*/);
		} else{
			tripLabel.setText(/*"<html><font color='#FA8072'>"+*/"Single="/*+"</font><html>"*/);
		}
		confirmButton.setStation(station);
		
		// Set background
		// ***************************************************************************************
		/*JLabel label = new JLabel(ConBKGD);
		label.setBounds(0, 0, ConBKGD.getIconWidth(), ConBKGD.getIconHeight());
		JPanel imagePanel = (JPanel) this.getContentPane();
		imagePanel.setOpaque(false);

		this.getLayeredPane().setLayout(null);
		this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(ConBKGD.getIconWidth(), ConBKGD.getIconHeight());
		this.setVisible(true);
		// ***************************************************************************************
		 * */
	}

}
