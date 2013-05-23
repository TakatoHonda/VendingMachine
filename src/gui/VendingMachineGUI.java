package gui;


import gui.parts.button.CoinButton;
import gui.parts.button.ResetButton;
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

import window.confirmWindow.ConfirmWindow;


import machineTest.*;
import manager.TransitionStateManager;
@SuppressWarnings("serial")
public
class VendingMachineGUI extends JFrame{
	private ImageIcon coin50Icon,coin100Icon,coin500Icon;
	private ImageIcon background;
	private InputCoinDisplay icDisplay;
	private ChargeCoinDisplay ccDisplay;
	private TransitionStateManager tsManager;
	private VendingMachineGUI gui;
	private StationButton yatuButton,tamaButton,araoButton,homeButton,kawaButton,heisButton,kamiButton,tatuButton;
	private StationLabel yatuLabel,tamaLabel,araoLabel,homeLabel,kawaLabel,heisLabel,kamiLabel,tatuLabel;
	private NoCoinLight no50Light,no100Light;
	private RoundTripButton roundTripButton;
	private CoinButton coin50Button,coin100Button,coin500Button;
	private ResetButton resetButton;
	private JLabel inputLabel,chargeLabel; 
	private JLabel no50Label,no100Label;
	private RetButton retButton;
	private ConfirmWindow confirmWindow;
//static VendingMachine vm = new VendingMachine();
	static VendingMachine vm = new VendingMachine();
	
	public static void main(String args[]){
		VendingMachineGUI gui= new VendingMachineGUI();
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
		background = new ImageIcon("./img/background.gif");
		gui = this;
		tatuButton= new StationButton("Tatsutaguchi",450,"Houhi",350,20);
		heisButton= new StationButton("Heisei",150,"Houhi",280,70);
		kamiButton= new StationButton("Kamikumamoto",150,"Kago_up",150,60);
		homeButton= new StationButton("Your place",0,"",210,110);
		yatuButton= new StationButton("Yatsushiro",450,"Kago_down",100,190);
		kawaButton= new StationButton("Kawashiri",150,"Kago_down",160,160);
		tamaButton= new StationButton("Tamana",200,"Kago_up",80,60);
		araoButton= new StationButton("Arao",450,"Kago_up",20,20);
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
		icDisplay= new InputCoinDisplay(vm);
		ccDisplay= new ChargeCoinDisplay(vm);
		no50Light= new NoCoinLight(50, vm,410, 160);
		no100Light= new NoCoinLight(100, vm,410, 140);
		NoCoinLight[] noCoinLight = {no50Light, no100Light};
		tsManager = new TransitionStateManager(icDisplay, ccDisplay, station,stLabel,noCoinLight);
		confirmWindow = new ConfirmWindow(gui, vm, tsManager);
		roundTripButton= new RoundTripButton(tsManager);
		coin50Button= new CoinButton(50, coin50Icon, 430, 5, tsManager, vm);
		coin100Button= new CoinButton(100, coin100Icon, 430, 45, tsManager, vm);
		coin500Button= new CoinButton(500, coin500Icon, 430, 85, tsManager, vm);
		resetButton= new ResetButton();
		inputLabel= new JLabel("Amount");
		chargeLabel= new JLabel("Charge");
		no50Label= new JLabel("50");
		no100Label= new JLabel("100");
		retButton= new RetButton(tsManager, vm);
		for(int i=0;i<station.length;i++)
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
		icDisplay.clear();
	}
	WindowListener windowListener = new WindowAdapter() {
        public void windowClosing(WindowEvent e) {
            vm.ioClose();
        }
    };

	
}
