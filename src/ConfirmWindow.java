import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class ConfirmWindow extends JFrame{
	ImageIcon ConButIcon = new ImageIcon("./img/confirm-button.png");
	ImageIcon CancelButIcon = new ImageIcon("./img/cancel-button.png");
	ImageIcon ConBKGD = new ImageIcon("./img/ConBKGD.jpg");

	private ReadTimeTable timeTable = new ReadTimeTable();
	private ConfirmWindow confirmWindow = this;
	private DispAmount dspCharge;

	private JLabel Trip;

	public static class Builder{
	}

	ConfirmWindow(final StationButton station, final DispAmount dspCharge, TransitionState transitionState,
			final VendingMachine vm, final VendGui gui){
		this.dspCharge = dspCharge;
		// Set confirmWindow property
		setTitle("Go to " + station.getName());
		setSize(280, 150);
		setLocation(100, 75);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setAlwaysOnTop(true);
		setResizable(false);
		setUndecorated(true);
		setLayout(null);
		gui.setEnabled(false);

		// stationNameLabel
		JLabel stationNameLabel = new JLabel("Ticket to " + station.getName() + ".");
		stationNameLabel.setBounds(50, 10, 200, 10);
		stationNameLabel.setForeground(Color.black);
		add(stationNameLabel);

		// priceLabel
		JLabel priceLabel = new JLabel("The Price is " + station.getPrice() + ".");
		priceLabel.setBounds(70, 30, 150, 10);
		priceLabel.setForeground(Color.black);
		add(priceLabel);

		// leaveTimeLabel
		JLabel leaveTimeLabel = new JLabel("Next departure time: " + timeTable.getLeaveTime(station.getRoute()));
		leaveTimeLabel.setBounds(50, 50, 200, 10);
		leaveTimeLabel.setForeground(Color.black);
		add(leaveTimeLabel);
		// RoundTrip or Single-trip label
		if (station.isRoundTrip()){
			Trip = new JLabel("Round trip!");
		} else{
			Trip = new JLabel("Single trip!");
		}
		Trip.setBounds(100, 70, 200, 15);
		add(Trip);

		// confirmButton
		JButton confirmButton = new JButton();
		confirmButton.setBounds(90, 90, 30, 30);
		confirmButton.setIcon(ConButIcon);
		confirmButton.setContentAreaFilled(false);
		confirmButton.setBorderPainted(false);
		confirmButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("ConfirmButton was clicked.");

				// IO out
				try{
					switch (station.getPrice()){
					case 150:
						vm.ioREQ150();
						break;
					case 200:
						vm.ioREQ200();
						break;
					case 450:
						vm.ioREQ450();
						break;
					}
					if (station.isRoundTrip()){
						vm.ioTWICE();
					}
					vm.ioSTB();

					// IO in//////////////////////
					for (int i = 0; i < 2; i ++){
						// gui.clear();
						if (vm.ioSEL150()){
						} else if (vm.ioSEL200()){
						} else if (vm.ioSEL450()){
						}
						vm.ioACK();
						if(station.isRoundTrip()){break;}
					}
					//////////////////////////////
				} catch (Exception e1){
					System.out.println("Error in io connect.");
				}
				confirmWindow.setVisible(false);
				gui.setEnabled(true);
				dspCharge.setCharge();
			}
		});
		add(confirmButton);

		// cancelButton
		JButton cancelButton = new JButton();
		cancelButton.setBounds(170, 90, 30, 30);
		cancelButton.setIcon(CancelButIcon);
		cancelButton.setContentAreaFilled(false);
		cancelButton.setBorderPainted(false);
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("CancelButton OK.");
				confirmWindow.setVisible(false);
				gui.setEnabled(true);
			}
		});
		add(cancelButton);

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
