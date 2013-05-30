package gui;


import gui.parts.button.CoinButton;
import gui.parts.button.RetButton;
import gui.parts.button.RoundTripButton;
import gui.parts.button.StationButton;
import gui.parts.display.ChargeCoinDisplay;
import gui.parts.display.InputCoinDisplay;
import gui.parts.display.NoCoinLight;
import gui.parts.label.StationLabel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import position.Position;

import machine.VendingMachine;
import manager.TransitionStateManager;
import window.confirmWindow.ConfirmWindow;

public class VendingMachineGUI extends JFrame{
	private ImageIcon coin50Icon, coin100Icon, coin500Icon;
	private ImageIcon background;
	private InputCoinDisplay icDisplay;
	private ChargeCoinDisplay ccDisplay;
	private StationButton yatuButton, tamaButton, araoButton, homeButton, kawaButton, heisButton, kamiButton, tatuButton;
	private StationLabel yatuLabel, tamaLabel, araoLabel, homeLabel, kawaLabel, heisLabel, kamiLabel, tatuLabel;
	private NoCoinLight no50Light, no100Light;
	private CoinButton coin50Button, coin100Button, coin500Button;
	private JLabel inputLabel, chargeLabel;
	private JLabel no50Label, no100Label;
	private RetButton retButton;
	private RoundTripButton roundTripButton;
	private ConfirmWindow confirmWindow;
	private Position coin50ButtonPos, coin100ButtonPos, coin500ButtonPos;
	private Position tatuButtonPos, yatuButtonPos, tamaButtonPos, araoButtonPos, homeButtonPos, kawaButtonPos, heisButtonPos, kamiButtonPos;
	private Position yatuLabelPos, tamaLabelPos, araoLabelPos, homeLabelPos, kawaLabelPos, heisLabelPos, kamiLabelPos, tatuLabelPos;
	private Position no50LightPos, no100LightPos;
	private static VendingMachine vm = new VendingMachine();
	private static TransitionStateManager tsManager;
	private static VendingMachineGUI gui;

	public static void main(String args[]){
		VendingMachineGUI gui = new VendingMachineGUI();
		gui.setVisible(true);
	}

	VendingMachineGUI(){
		initComponents();
		initGUI();
		vm.ioRST();
	}
	public void initComponents(){
		coin50Icon = new ImageIcon("./img/coin50.png");
		coin100Icon = new ImageIcon("./img/coin100.png");
		coin500Icon = new ImageIcon("./img/coin500.png");
		background = new ImageIcon("./img/background.png");
		gui = this;
		tatuButtonPos = new Position(350, 20);
		heisButtonPos = new Position(280, 70);
		kamiButtonPos = new Position(150, 60);
		homeButtonPos = new Position(210, 110);
		yatuButtonPos = new Position(100, 190);
		kawaButtonPos = new Position(160, 160);
		tamaButtonPos = new Position(80, 60);
		araoButtonPos = new Position(20, 20);
		tatuButton = new StationButton("Tatsutaguchi", 450, "Houhi", tatuButtonPos);
		heisButton = new StationButton("Heisei", 150, "Houhi", heisButtonPos);
		kamiButton = new StationButton("Kamikumamoto", 150, "Kago_up", kamiButtonPos);
		homeButton = new StationButton("Your place", 0, "", homeButtonPos);
		yatuButton = new StationButton("Yatsushiro", 450, "Kago_down", yatuButtonPos);
		kawaButton = new StationButton("Kawashiri", 150, "Kago_down", kawaButtonPos);
		tamaButton = new StationButton("Tamana", 200, "Kago_up", tamaButtonPos);
		araoButton = new StationButton("Arao", 450, "Kago_up", araoButtonPos);
		StationButton[] station = {tatuButton, heisButton, kamiButton, yatuButton, kawaButton, tamaButton, araoButton};
		tatuLabelPos = new Position(340, 54);
		heisLabelPos = new Position(310, 90);
		kamiLabelPos = new Position(140, 30);
		homeLabelPos = new Position(250, 120);
		yatuLabelPos = new Position(40, 170);
		kawaLabelPos = new Position(194, 179);
		tamaLabelPos = new Position(70, 90);
		araoLabelPos = new Position(50, 10);
		tatuLabel = new StationLabel("Tatsutaguchi", 450, tatuLabelPos);
		heisLabel = new StationLabel("Heisei", 150, heisLabelPos);
		kamiLabel = new StationLabel("Kamikumamoto", 150, kamiLabelPos);
		homeLabel = new StationLabel("Yourplace", 0, homeLabelPos);
		yatuLabel = new StationLabel("Yatsushiro", 450, yatuLabelPos);
		kawaLabel = new StationLabel("Kawashiri", 150, kawaLabelPos);
		tamaLabel = new StationLabel("Tamana", 200, tamaLabelPos);
		araoLabel = new StationLabel("Arao", 450, araoLabelPos);
		StationLabel[] stLabel = {tatuLabel, heisLabel, kamiLabel, homeLabel, yatuLabel, kawaLabel, tamaLabel, araoLabel};
		icDisplay = new InputCoinDisplay(vm);
		ccDisplay = new ChargeCoinDisplay(vm);
		no50LightPos = new Position(410, 160);
		no100LightPos = new Position(410, 140);
		no50Light = new NoCoinLight(50, vm, no50LightPos);
		no100Light = new NoCoinLight(100, vm, no100LightPos);
		NoCoinLight[] noCoinLight = {no50Light, no100Light};
		tsManager = new TransitionStateManager(icDisplay, ccDisplay, station, stLabel, noCoinLight);
		confirmWindow = new ConfirmWindow(gui, vm, tsManager);
		roundTripButton = new RoundTripButton(tsManager);
		coin50ButtonPos = new Position(430, 5);
		coin100ButtonPos = new Position(430, 45);
		coin500ButtonPos = new Position(430, 85);
		coin50Button = new CoinButton(50, coin50Icon, tsManager, vm, coin50ButtonPos);
		coin100Button = new CoinButton(100, coin100Icon, tsManager, vm, coin100ButtonPos);
		coin500Button = new CoinButton(500, coin500Icon, tsManager, vm, coin500ButtonPos);
		inputLabel = new JLabel("Amount");
		chargeLabel = new JLabel("Charge");
		no50Label = new JLabel("50");
		no100Label = new JLabel("100");
		retButton = new RetButton(tsManager, vm);
		for (int i = 0; i < station.length; i++)
			station[i].setConfirmWindow(confirmWindow);
	}

	public void initGUI(){
		// Set frame property
		setTitle("Ticket");
		setSize(480, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.white);
		// No use layout manager
		this.setLayout(null);
		addWindowListener(windowListener);

		// Display for coin
		add(icDisplay);
		add(ccDisplay);

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

		// Display label
		inputLabel.setBounds(285, 180, 75, 20);
		inputLabel.setForeground(Color.white);
		chargeLabel.setBounds(290, 205, 75, 20);
		chargeLabel.setForeground(Color.white);
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
		no50Label.setForeground(Color.white);
		no100Label.setBounds(380, 140, 75, 20);
		no100Label.setForeground(Color.white);
		add(no50Label);
		add(no100Label);

		// Two no coin Lights
		add(no50Light);
		add(no100Light);

		// Return coin button
		add(retButton);

		// Set background
		// ***************************************************************************************
		JLabel label = new JLabel(background);
		label.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
		JPanel imagePanel = (JPanel) getContentPane();
		imagePanel.setOpaque(false);
		getLayeredPane().setLayout(null);
		getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(background.getIconWidth(), background.getIconHeight());
		setVisible(true);
		// ***************************************************************************************

	}

	// Draw lines between stations
	@Override
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		Stroke stroke = new BasicStroke(2.0f);// width = 3
		g2d.setStroke(stroke);

		g2d.setColor(Color.yellow);
		g2d.drawLine(50, 75, 80, 100);
		g2d.drawLine(113, 100, 149, 100);
		g2d.drawLine(182, 100, 209, 135);
		g2d.drawLine(225, 166, 193, 200);
		g2d.drawLine(160, 215, 132, 230);
		g2d.drawLine(242, 150, 280, 110);
		g2d.drawLine(312, 110, 349, 60);

	}

	public void finished(){
		icDisplay.clear();
	}

	WindowListener windowListener = new WindowAdapter(){
		@Override
		public void windowClosing(WindowEvent e){
			vm.ioClose();
		}
	};

}
