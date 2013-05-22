package panel;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TicketPanel extends JFrame{
	public TicketPanel(String text){
		setBackground(Color.pink);
		setBounds(400, 100, 100, 100);
		setAlwaysOnTop(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setUndecorated(true);
		setLayout(null);
		setVisible(true);
	}
}
