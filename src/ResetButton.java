
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;


@SuppressWarnings("serial")
public class ResetButton extends JButton implements MouseListener{
	int x=430,y=205;
	ImageIcon icon = new ImageIcon("./img/rstIcon.png");
	ResetButton(){
		this.setBounds(x, y, 40, 21);
		this.setIcon(icon);
		}
	
	public void mouseClicked(MouseEvent e){
		
	}
	public void mouseEntered(MouseEvent e){}
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	

}
