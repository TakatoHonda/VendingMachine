package gui.parts.display;

import javax.swing.JTextField;

import machine.VendingMachine;

public class InputCoinDisplay extends JTextField{
	private VendingMachine vm;
	
	public InputCoinDisplay(VendingMachine vm){
		this.vm= vm;
		setEditable(false);
		setText("0");
		setHorizontalAlignment(RIGHT);
		setBounds(340, 180, 80, 20);
	}

	public void setAmount(int dispValue){
		setText(Integer.toString(dispValue));
	}

	public void clear(){
		setText("0");
	}

}
