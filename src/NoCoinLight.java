	import java.awt.Color;

	import javax.swing.JLabel;

	public class NoCoinLight extends JLabel{
		NoCoinLight(int x, int y){
			this.setBounds(x, y, 55, 20);
			this.setText("Åú");	// Use this mark to simulate the light
			this.setForeground(Color.green);
		}
		
		//If there is no coin, change color to red
		void ChangeColor(){
			this.setForeground(Color.red);
		}
	}

