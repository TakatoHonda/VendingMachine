package gui.parts.display;

import java.awt.Color;
import javax.swing.JLabel;

import position.Position;
import machine.VendingMachine;

public class NoCoinLight extends JLabel {
	private int lightValue;
	private static VendingMachine vm;
	
	public NoCoinLight(int lightValue, VendingMachine vm, Position position) {
		setBounds(position.x, position.y, 55, 20);
		setText("Åú"); // Use this mark to simulate the light
		setForeground(Color.pink);
		this.lightValue = lightValue;
		NoCoinLight.vm = vm;
	}

	// If there is no coin, change color to red.
	public void changeColor() {
		if (lightValue == 50 && vm.ioNO50()) {
			vm.ioACK();
			setForeground(Color.red);
		}else{
			setForeground(Color.pink);
		}
		if (lightValue == 100 && vm.ioNO100()) {
			setForeground(Color.red);
			vm.ioACK();
		}else{
			setForeground(Color.pink);
		}
	}

}