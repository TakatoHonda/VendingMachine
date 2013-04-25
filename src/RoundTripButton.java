import javax.swing.JButton;


@SuppressWarnings("serial")
public class RoundTripButton extends JButton{
	boolean isclicked = false;
	
	RoundTripButton(int x, int y){
		this.setBounds(x, y, 40, 50);
		this.setText("ª«");
	}
	
	boolean isClicked(){return isclicked;}

}
