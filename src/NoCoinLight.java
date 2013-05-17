import java.awt.Color;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class NoCoinLight extends JLabel {

	private TransitionState transitionState;
	private int coin;
	private VendingMachine vm;

	NoCoinLight(int x, int y, TransitionState transitionState, int coin, VendingMachine vm) {
		this.setBounds(x, y, 55, 20);
		this.setText("Åú"); // Use this mark to simulate the light
		this.setForeground(Color.pink);
		this.transitionState = transitionState;
		this.coin = coin;
		this.vm = vm;
	}

	// If there is no coin, change color to red.
	void changeColor() {
		if (coin == 50 && vm.ioNO50()) {
			vm.ioACK();
			this.setForeground(Color.red);
		}
		if (coin == 100 && vm.ioNO100()) {
			this.setForeground(Color.red);
		}
	}

}