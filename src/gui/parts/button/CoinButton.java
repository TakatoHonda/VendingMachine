package gui.parts.button;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import window.alertWindow.AlertWindow;

import machineTest.*;
import manager.TransitionStateManager;
@SuppressWarnings("serial")
public class CoinButton extends JButton implements MouseListener{
	private int value;
	private TransitionStateManager tsManager;
	private VendingMachine vm;

	public CoinButton(int value, ImageIcon icon, int x, int y, TransitionStateManager tsManager, VendingMachine vm){
		this.tsManager= tsManager;
		this.value= value;
		this.vm= vm;
		this.setBounds(x, y, 40, 40);
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);
		this.setIcon(icon);
		addMouseListener(this);
	}

	public void mouseClicked(MouseEvent e){
		try{
			switch (value){
			case 50:
				vm.ioC50();
				vm.ioSTB();
				break;
			case 100:
				vm.ioC100();
				vm.ioSTB();
				break;
			case 500:
				vm.ioC500();
				vm.ioSTB();
				break;
			}
			System.out.println("iovrFlag: "+ vm.ioIOVR()+" sovrFlag: "+vm.ioSOVR());
			if (!(vm.ioIOVR() || vm.ioSOVR())) {
				tsManager.setCoin(value);
			}else{
				String s= null;
				if (vm.ioSOVR()){
					s= "over 100 coins";
				} else if (vm.ioIOVR()){
					s= "over 1000 yen";
				}
				System.out.println("error: "+ s);
				vm.ioACK();
				AlertWindow alertWindow= new AlertWindow(s);
				alertWindow.setVisible(true);
				tsManager.retOverCoins(value);
			}
		} catch (Exception e1){
			System.out.println("Error in mouseClicked()");
		}
	}

	public void mouseEntered(MouseEvent e){
	}

	public void mouseExited(MouseEvent e){
	}

	public void mouseReleased(MouseEvent e){
	}

	public void mousePressed(MouseEvent e){
	}
}
