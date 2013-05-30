package gui.parts.button;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import position.Position;

import window.alertWindow.AlertWindow;
import machine.VendingMachine;
import manager.TransitionStateManager;

public class CoinButton extends JButton implements MouseListener{
	private int value;
	private final int WIDTH = 40, HEIGHT = 40;
	private TransitionStateManager tsManager;
	private VendingMachine vm;

	public CoinButton(int value, ImageIcon icon, TransitionStateManager tsManager, VendingMachine vm, Position position){
		this.tsManager = tsManager;
		this.value = value;
		this.vm = vm;
		setBounds(position.x, position.y, WIDTH, HEIGHT);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setIcon(icon);
		addMouseListener(this);
		

	}

	@Override
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
			System.out.println("iovrFlag: " + vm.ioIOVR() + " sovrFlag: " + vm.ioSOVR());
			if (!(vm.ioIOVR() || vm.ioSOVR())){
				tsManager.setCoin(value);
			}else{
				String s = null;
				if (vm.ioSOVR()){
					s = "over 100 coins";
				}else if (vm.ioIOVR()){
					s = "over 1000 yen";
				}
				System.out.println("error: " + s);
				vm.ioACK();
				AlertWindow alertWindow = new AlertWindow(s);
				alertWindow.setVisible(true);
				tsManager.retOverCoins(value);
				throw new UnsupportedOperationException();
			}
		}
		catch (Exception e1){
			System.out.println("Error in mouseClicked()");
		}
	}

	@Override
	public void mouseEntered(MouseEvent e){}

	@Override
	public void mouseExited(MouseEvent e){}

	@Override
	public void mouseReleased(MouseEvent e){}

	@Override
	public void mousePressed(MouseEvent e){}
}
