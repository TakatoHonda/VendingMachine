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
		setTitle("Go to " + StationName);
		setSize(280, 150);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBackground(Color.white);
		setResizable(false);
		this.setLayout(null);

		stationNameLabel = new JLabel("Ticket to " + StationName + ".");
		stationNameLabel.setBounds(50, 30, 200, 10);
		add(stationNameLabel);

		priceLabel = new JLabel("The Price is " + price + ".");
		priceLabel.setBounds(50, 50, 150, 10);
		add(priceLabel);

		leaveTimeLabel = new JLabel("Next departure time: " + timeTable.getLeaveTime(route));
		leaveTimeLabel.setBounds(50, 70, 200, 15);
		add(leaveTimeLabel);

		confirmButton = new JButton("Confirm");
		confirmButton.setBounds(50, 80, 80, 30);
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("ConfirmButton OK.");
			}
		});
		add(confirmButton);
		cancelButton = new JButton("Cancel");
		cancelButton.setBounds(150, 80, 80, 30);
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("CancelButton OK.");
				confirmWindow.setVisible(false);
			}
		});

		add(cancelButton);
	}

}
