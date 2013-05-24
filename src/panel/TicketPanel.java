package panel;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TicketPanel extends JFrame implements MouseListener{
	private ImageIcon ticket150Icon = new ImageIcon("./img/ticket150.png");
	private ImageIcon ticket200Icon = new ImageIcon("./img/ticket200.png");
	private ImageIcon ticket450Icon = new ImageIcon("./img/ticket450.png");
	private final int WIDTH=80;
	private final int HEIGHT=30;
	public TicketPanel(String price){
		switch(Integer.parseInt(price)){
		case 150:
			setBackground(ticket150Icon);
			break;
		case 200:
			setBackground(ticket200Icon);
			break;
		case 450:			
			setBackground(ticket450Icon);
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
	public void setBackground(ImageIcon icon){
		JLabel background = new JLabel(icon);
		background.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
		JPanel imagePanel = (JPanel) this.getContentPane();
		imagePanel.setOpaque(false);

		this.getLayeredPane().setLayout(null);
		this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(icon.getIconWidth(), icon.getIconHeight());
	}
	
	private int randint(int min,int max){
		Random rand = new Random();
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
