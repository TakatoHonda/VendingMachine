package panel;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TicketPanel extends JFrame implements MouseListener{
	private final int WIDTH=80;
	private final int HEIGHT=30;
	public TicketPanel(String price){
		switch(Integer.parseInt(price)){
		case 150:
			setBackground(Color.green);
			break;
		case 200:
			setBackground(Color.yellow);
			break;
		case 450:
			setBackground(Color.magenta);
			break;
		}
		setBounds(randint(0,470-WIDTH), randint(50,200-HEIGHT), WIDTH, HEIGHT);
		setAlwaysOnTop(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setUndecorated(true);
		setLayout(null);
		JLabel label = new JLabel(price);
		add(label);
		addMouseListener(this);
	}
	private int randint(int min,int max){
		Random rand = new Random();
		System.out.println("rand:"+((Math.abs(rand.nextInt())%max)+min));
		return ((Math.abs(rand.nextInt())%max)+min);
	}
	public void mouseClicked(MouseEvent e) {
		setVisible(false);
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
