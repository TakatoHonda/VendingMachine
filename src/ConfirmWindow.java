import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class ConfirmWindow extends JFrame {
	private JLabel stationNameLabel;
	private JLabel priceLabel;
	private JButton confirmButton;
	private JButton cancelButton;
	private JLabel leaveTimeLabel;
	private ReadTimeTable timeTable = new ReadTimeTable();
	private ConfirmWindow confirmWindow = this;
	
	ConfirmWindow(String StationName, String Time, int price, String route) {
		//Set confirmWindow property
		setTitle("Go to " + StationName);
		setSize(470, 250);
		setBackground(new Color(0x64000000, true));
		setAlwaysOnTop(true);
		setResizable(false);
		setUndecorated(true);
		setLayout(null);

		//stationNameLabel
		stationNameLabel = new JLabel("Ticket to " + StationName + ".");
		stationNameLabel.setBounds(150, 30, 200, 10);
		stationNameLabel.setForeground(Color.white);
		add(stationNameLabel);
		
		//priceLabel
		priceLabel = new JLabel("The Price is " + price + ".");
		priceLabel.setBounds(150, 50, 150, 10);
		priceLabel.setForeground(Color.white);
		add(priceLabel);

		//leaveTimeLabel
		leaveTimeLabel = new JLabel("Next departure time: " + timeTable.getLeaveTime(route));
		leaveTimeLabel.setBounds(150, 70, 200, 10);
		leaveTimeLabel.setForeground(Color.white);
		add(leaveTimeLabel);

		//confirmButton
		confirmButton = new JButton("Confirm");
		confirmButton.setBounds(150, 80, 80, 30);
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("ConfirmButton OK.");
			}
		});
		add(confirmButton);
		
		//CancelButton
		cancelButton = new JButton("Cancel");
		cancelButton.setBounds(250, 80, 80, 30);
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("CancelButton OK.");
				confirmWindow.setVisible(false);
			}
		});
		add(cancelButton);
	}

}
