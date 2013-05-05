import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;


@SuppressWarnings("serial")
public class CoinButton extends JButton implements MouseListener{
private int value;
private CoinCounter coinCounter;
private StationButton stations[];
private DispAmount dispInput;
	CoinButton(int value, int x, int y, ImageIcon icon, CoinCounter coinCounter, StationButton[] stations, DispAmount dispValue){
		this.coinCounter = coinCounter;
		this.value = value;
		this.dispInput = dispValue;
		this.stations = stations;
		this.setBounds(x, y, 40,40);
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);
		this.setIcon(icon);
		addMouseListener(this);
	}
	public int getValue(){return value;}
	
	public void mouseClicked(MouseEvent e){
		coinCounter.setCoin(value);
		dispInput.setAmount(coinCounter.getAmount());
		for(int i=0; i<stations.length; i++){
				stations[i].setButtonLight();
		}
		
	}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mousePressed(MouseEvent e){}
	}
