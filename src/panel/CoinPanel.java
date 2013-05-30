package panel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class CoinPanel extends JFrame implements MouseListener {

	private ImageIcon Coin50Icon = new ImageIcon("./img/chargeCoin50.png");
	private ImageIcon Coin100Icon = new ImageIcon("./img/chargeCoin100.png");
	private ImageIcon Coin500Icon = new ImageIcon("./img/chargeCoin500.png");

	private final int WIDTH = 60;
	private final int HEIGHT = 40;

	public CoinPanel(String price) {

		switch (Integer.parseInt(price)) {
		case 50:
			setBackground(Coin50Icon);
			break;
		case 100:
			setBackground(Coin100Icon);
			break;
		case 500:
			setBackground(Coin500Icon);
		}

		setBounds(randint(250, 470 - WIDTH), randint(50, 200 - HEIGHT), WIDTH,
				HEIGHT);
		setAlwaysOnTop(true);
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		setUndecorated(true);
		setLayout(null);
		JLabel label = new JLabel(price);
		add(label);
		addMouseListener(this);
	}

	public void setBackground(ImageIcon icon) {
		JLabel background = new JLabel(icon);
		background.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
		JPanel imagePanel = (JPanel) this.getContentPane();
		imagePanel.setOpaque(false);

		this.getLayeredPane().setLayout(null);
		this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(icon.getIconWidth(), icon.getIconHeight());
	}

	private int randint(int min, int max) {
		Random rand = new Random();
		System.out.println(((Math.abs(rand.nextInt()) % max) + min));
		return ((Math.abs(rand.nextInt()) % (max-min)) + min);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		setVisible(false);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}
