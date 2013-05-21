
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import machineTest.VendingMachine;




@SuppressWarnings("serial")
public class ConfirmWindow extends JFrame{
	ImageIcon ConButIcon = new ImageIcon("./img/confirm-button.png");
	ImageIcon CancelButIcon = new ImageIcon("./img/cancel-button.png");
	ImageIcon ConBKGD = new ImageIcon("./img/ConBKGD.jpg");
	private int hoge = 0;
	private ReadTimeTable timeTable = new ReadTimeTable();
	private VendingMachine vm;
	private JLabel stationNameLabel;
	private JLabel priceLabel;
	private JLabel leaveTimeLabel;
	private JLabel tripLabel;
	private ConfirmWindow confirmWindow = this;
	private VendGui gui;
	private TransitionStateManager tsManager;
	private JButton confirmButton;
	private JButton cancelButton;
	
	ConfirmWindow(VendGui gui, final VendingMachine vm, TransitionStateManager tsManager){
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

		confirmButton = new JButton();
		confirmButton.setBounds(90, 90, 30, 30);
		confirmButton.setIcon(ConButIcon);
		confirmButton.setContentAreaFilled(false);
		confirmButton.setBorderPainted(false);
		add(confirmButton);

		
		cancelButton = new JButton();
		cancelButton.setBounds(170, 90, 30, 30);
		cancelButton.setIcon(CancelButIcon);
		cancelButton.setContentAreaFilled(false);
		cancelButton.setBorderPainted(false);
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
		
		/////// confirmButton //////////
		confirmButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
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
				confirmButton.removeActionListener(this);
				cancelButton.removeActionListener(this);
				gui.setEnabled(true);
				tsManager.retCoins();
			}
		});
		
		// cancelButton
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("CancelButton OK.");
				confirmWindow.setVisible(false);
				confirmButton.removeActionListener(this);
				cancelButton.removeActionListener(this);
				gui.setEnabled(true);
			}
		});

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
