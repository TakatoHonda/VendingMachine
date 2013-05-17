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
	private ImageIcon coin50Icon = new ImageIcon("./img/coin50.png");
	private ImageIcon coin100Icon = new ImageIcon("./img/coin100.png");
	private ImageIcon coin500Icon = new ImageIcon("./img/coin500.png");
	private ImageIcon background = new ImageIcon("./img/background.gif");
	private DispAmount dspInput;
	private DispAmount dspCharge;
	static CoinCounter coinCounter = new CoinCounter();
	static VendingMachine vm = new VendingMachine();
	private VendGui gui = this;
	private StationButton yatuButton;
	private StationButton tamaButton;
	private StationButton araoButton;
	private StationButton homeButton;
	private StationButton kawaButton;
	private StationButton heisButton;
	private StationButton kamiButton;
	private StationButton tatuButton;
	public static void main(String args[]){
		VendGui gui = new VendGui("Ticket");
		gui.setVisible(true);
		vm.ioRET();
	}

	VendGui(String title){
		// Set frame property
		setTitle(title);
		setSize(480, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.white);
		// No use layout manager
		this.setLayout(null);

		// Display for coin
		dspInput = new DispAmount(340, 180, vm,gui);
		dspCharge = new DispAmount(340, 205, vm,gui);
		add(dspInput);
		add(dspCharge);

		// Set Station buttons
		tatuButton = new StationButton.Builder(dspCharge, coinCounter, vm, gui)
						.name("Tatsutaguchi").price(450).route("Houhi").posX(350).posY(20).build();
		heisButton = new StationButton.Builder(dspCharge, coinCounter, vm, gui)
						.name("Heisei").price(150).route("Houhi").posX(280).posY(70).build();
		kamiButton = new StationButton.Builder(dspCharge, coinCounter, vm, gui)
						.name("Kamikumamoto").price(150).route("Kago_up").posX(150).posY(60).build();
		homeButton = new StationButton.Builder(dspCharge, coinCounter, vm, gui)
						.name("Your place").price(0).route("").posX(210).posY(110).build();
		yatuButton = new StationButton.Builder(dspCharge, coinCounter, vm, gui)
						.name("Yatsushiro").price(450).route("Kago_down").posX(100).posY(190).build();
		kawaButton = new StationButton.Builder(dspCharge, coinCounter, vm, gui)
						.name("Kawashiri").price(150).route("Kago_down").posX(160).posY(160).build();
		tamaButton = new StationButton.Builder(dspCharge, coinCounter, vm, gui)
						.name("Tamana").price(200).route("Kago_up").posX(80).posY(60).build();
		araoButton = new StationButton.Builder(dspCharge, coinCounter, vm, gui)
						.name("Arao").price(450).route("Kago_up").posX(20).posY(20).build();
		StationButton station[] = { tatuButton, heisButton, kamiButton, yatuButton, kawaButton, tamaButton, araoButton };
		add(tatuButton);
		add(heisButton);
		add(kamiButton);
		add(homeButton);
		add(yatuButton);
		add(kawaButton);
		add(tamaButton);
		add(araoButton);

		// Set Coin buttons
		CoinButton coin50Button = new CoinButton(50, 430, 5, coin50Icon, coinCounter, station, dspInput, vm);
		CoinButton coin100Button = new CoinButton(100, 430, 45, coin100Icon, coinCounter, station, dspInput, vm);
		CoinButton coin500Button = new CoinButton(500, 430, 85, coin500Icon, coinCounter, station, dspInput, vm);
		add(coin50Button);
		add(coin100Button);
		add(coin500Button);

		// Set reset button
		ResetButton rstButton = new ResetButton();
		add(rstButton);

		// Display label
		DisplayLabel inputLabel = new DisplayLabel("Amount", 285, 180);
		DisplayLabel chargeLabel = new DisplayLabel("Charge", 290, 205);
		add(inputLabel);
		add(chargeLabel);

		// Station Label
		StationLabel tatuLabel = new StationLabel("Tatsutaguchi", 340, 54, 450);
		StationLabel heisLabel = new StationLabel("Heisei", 310, 90, 150);
		StationLabel kamiLabel = new StationLabel("Kamikumamoto", 140, 30, 150);
		StationLabel homeLabel = new StationLabel("Yourplace", 250, 120, 0);
		StationLabel yatuLabel = new StationLabel("Yatsushiro", 40, 170, 450);
		StationLabel kawaLabel = new StationLabel("Kawashiri", 194, 179, 150);
		StationLabel tamaLabel = new StationLabel("Tamana", 70, 90, 200);
		StationLabel araoLabel = new StationLabel("Arao", 50, 10, 450);
		StationLabel[] stLabel = { tatuLabel, heisLabel, kamiLabel, homeLabel, yatuLabel, kawaLabel, tamaLabel,
				araoLabel };
		add(tatuLabel);
		add(heisLabel);
		add(kamiLabel);
		add(homeLabel);
		add(yatuLabel);
		add(kawaLabel);
		add(tamaLabel);
		add(araoLabel);

		// A round trip button
		RoundTripButton rtpButton = new RoundTripButton(stLabel, station);
		add(rtpButton);

		// NoCionLihgt labels
		DisplayLabel No50Label = new DisplayLabel("50", 380, 160);
		DisplayLabel No100Label = new DisplayLabel("100", 380, 140);
		add(No50Label);
		add(No100Label);

		// Two no coin Lights
		NoCoinLight no50Light = new NoCoinLight(410, 160, coinCounter, 50, vm);
		NoCoinLight no100Light = new NoCoinLight(410, 140, coinCounter, 100, vm);
		add(no50Light);
		add(no100Light);

		// Return coin button
		RetButton retButton = new RetButton(coinCounter, dspInput, no50Light, no100Light, station, vm);
		add(retButton);

		// Set background
		// ***************************************************************************************
		JLabel label = new JLabel(background);
		label.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
		JPanel imagePanel = (JPanel) this.getContentPane();
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
		Graphics2D g2d = (Graphics2D) g;
		Stroke stroke = new BasicStroke(2.0f);// width = 3
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
