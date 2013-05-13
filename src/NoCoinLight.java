import java.awt.Color;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class NoCoinLight extends JLabel {

	CoinCounter coinCounter;
	int coin;

	NoCoinLight(int x, int y, CoinCounter coinCounter, int coin) {
		this.setBounds(x, y, 55, 20);
		this.setText("Åú"); // Use this mark to simulate the light
		this.setForeground(Color.pink);
		this.coinCounter = coinCounter;
		this.coin = coin;
	}

	// If there is no coin, change color to red
	void changeColor() {
		if (coin == 50 && coinCounter.getCoin50() < 3) {
			this.setForeground(Color.red);
		}
		if (coin == 100 && coinCounter.getCoin100() < 3) {
			this.setForeground(Color.red);
		}
	}

}