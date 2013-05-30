package gui.parts.display;

import javax.swing.JTextField;

import panel.CoinPanel;

import machine.VendingMachine;

public class ChargeCoinDisplay extends JTextField{
	private int c50, c100, c500;
	private final int X=340,Y=205,WIDTH=80,HEIGHT=20;
	private VendingMachine vm;

	public ChargeCoinDisplay(VendingMachine vm){
		this.vm = vm;
		c50 = 0;
		c100 = 0;
		c500 = 0;
		setText("0");
		setEditable(false);
		setHorizontalAlignment(RIGHT);
		setBounds(X, Y, WIDTH, HEIGHT);
		}

	public void setCharge(){
		for (int i = 0; i <= 15; i++){
			if (vm.ioR50()){
				c50++;
				System.out.println("ret coin50");
				vm.ioACK();
			}
			if (vm.ioR100()){
				c100++;
				System.out.println("ret coin100");
				vm.ioACK();
			}
			if (vm.ioR500()){
				c500++;
				System.out.println("ret coin500");
				vm.ioACK();
			}
		}
		CoinPanel[] coinPanel50 = new CoinPanel[c50];
		CoinPanel[] coinPanel100 = new CoinPanel[c100];
		CoinPanel[] coinPanel500 = new CoinPanel[c500];
		for(int i=0;i<c50;i++){
			coinPanel50[i] = new CoinPanel("50");
			coinPanel50[i].setVisible(true);
		}
		for(int i=0;i<c100;i++){
			coinPanel100[i] = new CoinPanel("100");
			coinPanel100[i].setVisible(true);
		}
		for(int i=0;i<c500;i++){
			coinPanel500[i] = new CoinPanel("500");
			coinPanel500[i].setVisible(true);
		}
		
		this.setText(Integer.toString(c50 * 50 + c100 * 100 + c500 * 500));
		System.out.println("c50: "+c50+" c100: "+c100+" c500: "+c500);
		clearCoin();
	}
	public void clearCoin(){
		c50 = 0;
		c100 = 0;
		c500 = 0;
	}

}
