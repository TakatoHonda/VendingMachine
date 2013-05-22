package gui.parts.display;

import javax.swing.JTextField;

import machineTest.VendingMachine;

public class ChargeCoinDisplay extends JTextField{
	private int c50, c100, c500;
	private VendingMachine vm;

	public ChargeCoinDisplay(VendingMachine vm){
		c50= 0;
		c100= 0;
		c500= 0;
		this.vm= vm;
		setBounds(340, 205, 80, 20);
		this.setText("0");
		this.vm= vm;
		this.setEditable(false);
		this.setHorizontalAlignment(RIGHT);
	}

	public void setCharge(){
		for (int i= 0; i<= 15; i++){
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
		this.setText(Integer.toString(c50* 50+ c100* 100+ c500* 500));
		c50= 0;
		c100= 0;
		c500= 0;
	}

}
