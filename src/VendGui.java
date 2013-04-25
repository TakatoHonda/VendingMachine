//Ç®Ç¢Ç®Ç¢setBackgroundÇ…ïsãÔçáÇ†ÇÈÇ∆Ç©ï∑Ç¢ÇƒÇÀÇ¶ÇÊwãñÇ≥Ç w
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
class VendGui extends JFrame{
	//Path to icons.
	ImageIcon coin50_icon  = new ImageIcon("../img/coin50.png");
	ImageIcon coin100_icon = new ImageIcon("../img/coin100.png");
	ImageIcon coin500_icon = new ImageIcon("../img/coin500.png");
	//Path to colors.
	ImageIcon red 			= new ImageIcon("../img/red.jpg");
	ImageIcon light_green 	= new ImageIcon("../img/light_green.jpg");
	ImageIcon yellow 		= new ImageIcon("../img/yellow.jpg");
	
	
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
		
		//No use layout manager.
		this.setLayout(null);
		
		//Station buttons set.
		//StationButton("station_name", price, x, y)
		StationButton tatu_btn = new StationButton("ó≥ìcå˚", 450, 350, 20);
		StationButton heis_btn = new StationButton("ïΩê¨", 150, 280, 70);
		StationButton kami_btn = new StationButton("è„åFñ{", 150, 150, 60);
		StationButton home_btn = new StationButton("åªç›ín", 0, 210, 110);
		StationButton yatu_btn = new StationButton("î™ë„", 450, 100, 190);
		StationButton kawa_btn = new StationButton("êÏêK", 150, 160, 160);
		StationButton tama_btn = new StationButton("ã ñº", 200, 80, 60);
		StationButton arao_btn = new StationButton("çrîˆ", 450, 20, 20);
		add(tatu_btn);
		add(heis_btn);
		add(kami_btn);
		add(home_btn);
		add(yatu_btn);
		add(kawa_btn);
		add(tama_btn);
		add(arao_btn);
		
		//Coin buttons set.
		//CoinButton(value,x,y,icon)
		CoinButton coin50_btn  = new CoinButton(50, 440,10, coin50_icon);
		CoinButton coin100_btn = new CoinButton(100, 440,50, coin100_icon);
		CoinButton coin500_btn = new CoinButton(500, 440,90, coin500_icon);
		add(coin50_btn);
		add(coin100_btn);
		add(coin500_btn);
		
		//A round trip button.
		RoundTripButton rtp_btn = new RoundTripButton(440, 130);
		add(rtp_btn);
		
		//Reset button.
		ResetButton rst_btn = new ResetButton(438,205, red);
		add(rst_btn);
		
		//Return coin button.
		RetButton ret_btn = new RetButton(438, 180);
		add(ret_btn);
		
		//Display
		DispAmount input_dsp  = new DispAmount(340, 180);
		DispAmount charge_dsp = new DispAmount(340, 205);
		add(input_dsp);
		add(charge_dsp);
		
		//Display label
		JLabel input_label = new JLabel("ìäì¸ã‡äz");
		JLabel charge_label = new JLabel();
		input_label.setLocation(200,180);
		charge_label.setLocation(300,205);
		add(input_label);
		add(charge_label);
	}
	
}
