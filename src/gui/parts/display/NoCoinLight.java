package gui.parts.display;
import java.awt.Color;

import javax.swing.JLabel;

import machineTest.VendingMachine;
import manager.TransitionStateManager;

@SuppressWarnings("serial")
public class NoCoinLight extends JLabel {

	private int coin;
	private VendingMachine vm;

	public NoCoinLight(int coin, VendingMachine vm, int x, int y) {
		this.setBounds(x, y, 55, 20);
		this.setText("Åú"); // Use this mark to simulate the light
		this.setForeground(Color.pink);
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