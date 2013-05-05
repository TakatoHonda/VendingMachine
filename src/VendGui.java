//Ç®Ç¢Ç®Ç¢setBackgroundÇ…ïsãÔçáÇ†ÇÈÇ∆Ç©ï∑Ç¢ÇƒÇÀÇ¶ÇÊwãñÇ≥Ç w
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

@SuppressWarnings("serial")
class VendGui extends JFrame{
	//Path to icons.
	ImageIcon coin50_icon  = new ImageIcon("../img/coin50.png");
	ImageIcon coin100_icon = new ImageIcon("../img/coin100.png");
	ImageIcon coin500_icon = new ImageIcon("../img/coin500.png");
	ImageIcon red 			= new ImageIcon("../img/red.jpg");
	ImageIcon light_green 	= new ImageIcon("../img/light_green.jpg");
	//Path to background image.
	DispAmount input_dsp;
	DispAmount charge_dsp;
	CoinCounter coinCounter = new CoinCounter(input_dsp);
	
	//main
	public static void main(String args[]){
		VendGui gui = new VendGui("Ticket");
		gui.setVisible(true);
	}
	
	VendGui(String title){
		//set frame property.
		setTitle(title);
		setSize(480, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setBackground(Color.white);
		
		//No use layout manager.
		this.setLayout(null);
		
		//Station buttons set.
		StationButton tatu_btn = new StationButton("Tatsutaguchi", 450, 350, 20, coinCounter);
		StationButton heis_btn = new StationButton("Heisei", 150, 280, 70, coinCounter);
		StationButton kami_btn = new StationButton("Kamikumamoto", 150, 150, 60, coinCounter); 
		StationButton home_btn = new StationButton("Yourplace.", 0, 210, 110, coinCounter);
		StationButton yatu_btn = new StationButton("Yatsushiro", 450, 100, 190, coinCounter);
		StationButton kawa_btn = new StationButton("Kawashiri", 150, 160, 160, coinCounter);
		StationButton tama_btn = new StationButton("Tamana", 200, 80, 60, coinCounter);
		StationButton arao_btn = new StationButton("Arao", 450, 20, 20, coinCounter);
		StationButton stations[] = {tatu_btn, heis_btn, kami_btn, yatu_btn, kawa_btn, tama_btn, arao_btn};
		add(tatu_btn);add(heis_btn);add(kami_btn);add(home_btn);
		add(yatu_btn);add(kawa_btn);add(tama_btn);add(arao_btn);
		//Display
		input_dsp  = new DispAmount(340, 180);
		charge_dsp = new DispAmount(340, 205);
		add(input_dsp);
		add(charge_dsp);
		
		//Coin buttons set.
		CoinButton coin50_btn  = new CoinButton(50, 435,5, coin50_icon, coinCounter, stations, input_dsp);
		CoinButton coin100_btn = new CoinButton(100, 435,45, coin100_icon, coinCounter, stations, input_dsp);
		CoinButton coin500_btn = new CoinButton(500, 435,85, coin500_icon, coinCounter, stations, input_dsp);
		add(coin50_btn);
		add(coin100_btn);
		add(coin500_btn);
		
		
		//Reset button.
		ResetButton rst_btn = new ResetButton();
		add(rst_btn);
		
		//Return coin button.
		RetButton ret_btn = new RetButton();
		add(ret_btn);
		
		
	
		//Display label
		DisplayLabel input_lbl = new DisplayLabel("Amount", 285, 180);
		DisplayLabel charge_lbl = new DisplayLabel("Charge", 290,205);
		add(input_lbl);
		add(charge_lbl);
		//Station Label
		StationLabel tatu_lbl = new StationLabel("Tatsutaguchi", 340, 54, 450);
		StationLabel heis_lbl = new StationLabel("Heisei", 310, 90, 150);
		StationLabel kami_lbl = new StationLabel("Kamikumamoto", 140, 30, 150);
		StationLabel home_lbl = new StationLabel("Yourplace", 250, 120, 0);
		StationLabel yatu_lbl = new StationLabel("Yatsushiro", 40, 170, 450);
		StationLabel kawa_lbl = new StationLabel("Kawashiri", 194, 179, 150);
		StationLabel tama_lbl = new StationLabel("Tamana", 70, 90, 200);
		StationLabel arao_lbl = new StationLabel("Arao", 50, 10, 450);
		StationLabel[] st_lbl = {tatu_lbl, heis_lbl, kami_lbl, home_lbl, yatu_lbl, kawa_lbl, tama_lbl, arao_lbl};
		add(tatu_lbl);add(heis_lbl);add(kami_lbl);add(home_lbl);
		add(yatu_lbl);add(kawa_lbl);add(tama_lbl);add(arao_lbl);
		//A round trip button.
		RoundTripButton rtp_btn = new RoundTripButton(st_lbl,stations);
		add(rtp_btn);
		
		
		//NoCionLihgt labels
		DisplayLabel No50_lbl = new DisplayLabel("50", 350, 160);
		DisplayLabel No100_lbl = new DisplayLabel("100", 350, 140);
		add(No50_lbl);
		add(No100_lbl);
		
		//Two no coin lights
		NoCoinLight No50_Coin = new NoCoinLight(380,160);
		NoCoinLight No100_Coin = new NoCoinLight(380,140);
		add(No50_Coin);
		add(No100_Coin);
		// Use the method "ChangeColor(void)", you can change the color to red.
		No50_Coin.ChangeColor();
		
	}	

			
	//Draw lines between stations
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d=(Graphics2D)g;
		Stroke stroke=new BasicStroke(2.0f);// width = 3 
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
			

			
			
	
}
