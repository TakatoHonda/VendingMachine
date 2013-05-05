import javax.swing.JButton;
import java.awt.event.*;

@SuppressWarnings("serial")
public class RoundTripButton extends JButton implements MouseListener{
	boolean isClickedFlag = false;
	StationLabel[] st_lbl;
	RoundTripButton(int x, int y, StationLabel[] st_lbl){
		this.setBounds(x, y, 40, 50);
		this.setText("↑↓");
		this.st_lbl = st_lbl;
		addMouseListener(this);
	}
	
public boolean isClicked(){
	return isClickedFlag;
}

	
	
public void mouseClicked(MouseEvent e){
	if(isClickedFlag == false){
		isClickedFlag = true;
		for(int i=0; i<st_lbl.length; i++){
		st_lbl[i].setPrice(isClickedFlag);
		}
	}
	else{
		isClickedFlag = false;
		for(int i=0; i<st_lbl.length; i++){
		st_lbl[i].setPrice(isClickedFlag);
		}
	}
}

public void mouseEntered(MouseEvent e){}
public void mouseExited(MouseEvent e){}
public void mouseReleased(MouseEvent e){}
public void mousePressed(MouseEvent e){}

	
}