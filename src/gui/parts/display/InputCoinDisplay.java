package gui.parts.display;

import javax.swing.JTextField;

import machineTest.VendingMachine;

@SuppressWarnings("serial")
public class InputCoinDisplay extends JTextField{
	private VendingMachine vm;
	private int dspValue;

	public InputCoinDisplay(VendingMachine vm){
		dspValue= 0;
		this.vm= vm;
		setEditable(false);
		setText(""+ dspValue);
		setHorizontalAlignment(RIGHT);
		setBounds(340, 180, 80, 20);
	}

	public void setAmount(int dispValue){
		this.setText(Integer.toString(dispValue));
	}

	public void clear(){
		dspValue= 0;
		this.setText(""+ dspValue);
	}

}
