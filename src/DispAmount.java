import javax.swing.JTextField;

import machineTest.VendingMachine;

@SuppressWarnings("serial")
public class DispAmount extends JTextField {
	private int dspValue;
	private int chargeCoin50, chargeCoin100, chargeCoin500;
	private VendingMachine vm;
	DispAmount(int x, int y, VendingMachine vm) {
		this.dspValue = 0;
		this.chargeCoin50=0;
		this.chargeCoin100=0;
		this.chargeCoin500=0;
		this.setBounds(x, y, 80, 20);
		this.setText(Integer.toString(dspValue));
		this.vm = vm;
		this.setEditable(false);
		this.setHorizontalAlignment(RIGHT);
	}

	public void setAmount(int dispValue) {
		this.setText(Integer.toString(dispValue));
	}

	public void setCharge() {		
		for(int i=0;i<=15;i++) {
			System.out.println("charge set: i="+i);
			if (vm.ioR50()) {
				chargeCoin50++;
				System.out.println("ret coin50");
				vm.ioACK();
			}
			if (vm.ioR100()) {
				chargeCoin100++;
				System.out.println("ret coin100");
				vm.ioACK();
			}
			if (vm.ioR500()) {
				chargeCoin500++;
				System.out.println("ret coin500");
				vm.ioACK();
			}
		}	
		System.out.println("Charge coin is\n"+"50:"+chargeCoin50+" 100:"+chargeCoin100+" 500:"+chargeCoin500);	
		this.setText(Integer.toString(chargeCoin50*50+chargeCoin100*100+chargeCoin500*500));
		chargeCoin50=0;
		chargeCoin100=0;
		chargeCoin500=0;
	}

	public void clear() {
		dspValue = 0;
		this.setText("" + dspValue);
	}

}
