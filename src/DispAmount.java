import javax.swing.JTextField;

@SuppressWarnings("serial")
public class DispAmount extends JTextField {
	private int dspValue;
	private int c50, c100, c500;
	private VendingMachine vm;
	DispAmount(int x, int y, VendingMachine vm) {
		this.dspValue = 0;
		this.c50=0;
		this.c100=0;
		this.c500=0;
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
		while (vm.ioR50() || vm.ioR100() || vm.ioR500()) {
			if (vm.ioR50()) {
				c50++;
				vm.ioACK();
			}
			if (vm.ioR100()) {
				c100++;
				vm.ioACK();
			}
			if (vm.ioR500()) {
				c500++;
				vm.ioACK();
			}
		}
		
		//this.setText("c50 Å~"+c50+"c100 x"+c100+"c500 x"+c500);
		this.setText(Integer.toString(c50*50+c100*100+c500*500));
	}

	public void clear() {
		dspValue = 0;
		this.setText("" + dspValue);
	}

}
