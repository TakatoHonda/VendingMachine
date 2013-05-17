import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
class VendGui extends JFrame{
	private ImageIcon coin50Icon;
	private ImageIcon coin100Icon;
	private ImageIcon coin500Icon;
	private ImageIcon background;
	private DispAmount dspInput;
	private DispAmount dspCharge;
	private TransitionState transitionState;
	static VendingMachine vm;
	private VendGui gui;
	private StationButton yatuButton;
	private StationButton tamaButton;
	private StationButton araoButton;
	private StationButton homeButton;
	private StationButton kawaButton;
	private StationButton heisButton;
	private StationButton kamiButton;
	private StationButton tatuButton;
	private StationLabel yatuLabel;
	private StationLabel tamaLabel;
	private StationLabel araoLabel;
	private StationLabel homeLabel;
	private StationLabel kawaLabel;
	private StationLabel heisLabel;
	private StationLabel kamiLabel;
	private StationLabel tatuLabel;
	private NoCoinLight no50Light;
	private NoCoinLight no100Light;
	private RoundTripButton roundTripButton;
	private CoinButton coin50Button;
	private CoinButton coin100Button;
	private CoinButton coin500Button;
	private ResetButton resetButton;
	private JLabel inputLabel;
	private JLabel chargeLabel; 
	private JLabel no50Label;
	private JLabel no100Label;
	private RetButton retButton;
	
	public static void main(String args[]){
		VendGui gui= new VendGui();
		gui.setVisible(true);
		vm.ioRST();
	}

	VendGui(){
		initCompornents();
		initGUI();
	}

	public void initCompornents(){
		coin50Icon = new ImageIcon("./img/coin50.png");
		coin100Icon = new ImageIcon("./img/coin100.png");
		coin500Icon = new ImageIcon("./img/coin500.png");
		background = new ImageIcon("./img/background.gif");
		gui = this;
		tatuButton= new StationButton.Builder(dspCharge, transitionState, vm, gui).name("Tatsutaguchi").price(450)
				.route("Houhi").posX(350).posY(20).build();
		heisButton= new StationButton.Builder(dspCharge, transitionState, vm, gui).name("Heisei").price(150).route("Houhi")
				.posX(280).posY(70).build();
		kamiButton= new StationButton.Builder(dspCharge, transitionState, vm, gui).name("Kamikumamoto").price(150)
				.route("Kago_up").posX(150).posY(60).build();
		homeButton= new StationButton.Builder(dspCharge, transitionState, vm, gui).name("Your place").price(0).route("")
				.posX(210).posY(110).build();
		yatuButton= new StationButton.Builder(dspCharge, transitionState, vm, gui).name("Yatsushiro").price(450)
				.route("Kago_down").posX(100).posY(190).build();
		kawaButton= new StationButton.Builder(dspCharge, transitionState, vm, gui).name("Kawashiri").price(150)
				.route("Kago_down").posX(160).posY(160).build();
		tamaButton= new StationButton.Builder(dspCharge, transitionState, vm, gui).name("Tamana").price(200)
				.route("Kago_up").posX(80).posY(60).build();
		araoButton= new StationButton.Builder(dspCharge, transitionState, vm, gui).name("Arao").price(450).route("Kago_up")
				.posX(20).posY(20).build();
		StationButton[] station = { tatuButton, heisButton, kamiButton, yatuButton, kawaButton, tamaButton, araoButton };
		tatuLabel= new StationLabel("Tatsutaguchi", 340, 54, 450);
		heisLabel= new StationLabel("Heisei", 310, 90, 150);
		kamiLabel= new StationLabel("Kamikumamoto", 140, 30, 150);
		homeLabel= new StationLabel("Yourplace", 250, 120, 0);
		yatuLabel= new StationLabel("Yatsushiro", 40, 170, 450);
		kawaLabel= new StationLabel("Kawashiri", 194, 179, 150);
		tamaLabel= new StationLabel("Tamana", 70, 90, 200);
		araoLabel= new StationLabel("Arao", 50, 10, 450);
		StationLabel[] stLabel= { tatuLabel, heisLabel, kamiLabel, homeLabel, yatuLabel, kawaLabel, tamaLabel,
				araoLabel };
		no50Light= new NoCoinLight(410, 160, transitionState, 50, vm);
		no100Light= new NoCoinLight(410, 140, transitionState, 100, vm);
		NoCoinLight[] noCoinLight = {no50Light, no100Light};
		dspInput= new DispAmount(340, 180, vm);
		transitionState = new TransitionState(dspInput, station);
		roundTripButton= new RoundTripButton(stLabel, station, transitionState);
		dspCharge= new DispAmount(340, 205, vm);
		coin50Button= new CoinButton(50, coin50Icon, 430, 5, transitionState, vm);
		coin100Button= new CoinButton(100, coin100Icon, 430, 45, transitionState, vm);
		coin500Button= new CoinButton(500, coin500Icon, 430, 85, transitionState, vm);
		resetButton= new ResetButton();
		inputLabel= new JLabel("Amount");
		chargeLabel= new JLabel("Charge");
		no50Label= new JLabel("50");
		no100Label= new JLabel("100");
		retButton= new RetButton(transitionState, vm);
			}

	public void initGUI(){
		// Set frame property
		setTitle("Ticket");
		setSize(480, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.white);
		// No use layout manager
		this.setLayout(null);

		// Display for coin
		add(dspInput);
		add(dspCharge);

		// Set Station buttons
		add(tatuButton);
		add(heisButton);
		add(kamiButton);
		add(homeButton);
		add(yatuButton);
		add(kawaButton);
		add(tamaButton);
		add(araoButton);

		// Set Coin buttons
		add(coin50Button);
		add(coin100Button);
		add(coin500Button);

		// Set reset button
		add(resetButton);

		// Display label
		inputLabel.setBounds(285, 180, 75, 20);
		chargeLabel.setBounds(290, 205, 75, 20);
		add(inputLabel);
		add(chargeLabel);

		// Station Label
		add(tatuLabel);
		add(heisLabel);
		add(kamiLabel);
		add(homeLabel);
		add(yatuLabel);
		add(kawaLabel);
		add(tamaLabel);
		add(araoLabel);

		// A round trip button
		
		add(roundTripButton);

		// NoCionLihgt labels
		no50Label.setBounds(380, 160, 75, 20);
		no100Label.setBounds(380, 140, 75, 20);
		add(no50Label);
		add(no100Label);

		// Two no coin Lights
		add(no50Light);
		add(no100Light);

		// Return coin button
		add(retButton);

		// Set background
		// ***************************************************************************************
		JLabel label= new JLabel(background);
		label.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
		JPanel imagePanel= (JPanel) this.getContentPane();
		imagePanel.setOpaque(false);
		this.getLayeredPane().setLayout(null);
		this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(background.getIconWidth(), background.getIconHeight());
		this.setVisible(true);
		// ***************************************************************************************

	}

	// Draw lines between stations
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d= (Graphics2D) g;
		Stroke stroke= new BasicStroke(2.0f);// width = 3
		g2d.setStroke(stroke);

		g2d.setColor(Color.ORANGE);
		g2d.drawLine(50, 75, 80, 100);
		g2d.drawLine(113, 100, 149, 100);
		g2d.drawLine(182, 100, 209, 135);
		g2d.drawLine(225, 166, 193, 200);
		g2d.drawLine(160, 215, 132, 230);
		g2d.drawLine(242, 150, 280, 110);
		g2d.drawLine(312, 110, 349, 60);

	}

	public void finished(){
		dspInput.clear();
	}
}
