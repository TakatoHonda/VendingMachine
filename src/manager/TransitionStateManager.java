package manager;

import gui.parts.button.StationButton;
import gui.parts.display.ChargeCoinDisplay;
import gui.parts.display.InputCoinDisplay;
import gui.parts.display.NoCoinLight;
import gui.parts.label.StationLabel;

public class TransitionStateManager{
	private int coin50;
	private int coin100;
	private int coin500;
	private boolean isRoundTrip;
	private InputCoinDisplay icDisplay;
	private ChargeCoinDisplay ccDisplay;
	private NoCoinLight[] noCoinLight;
	private StationButton[] station;
	private StationLabel[] stLabel;

	public TransitionStateManager(InputCoinDisplay icDisplay, ChargeCoinDisplay ccDisplay, StationButton[] station,
			StationLabel[] stLabel, NoCoinLight[] noCoinLight){
		coin50= 0;
		coin100= 0;
		coin500= 0;
		this.station= station;
		this.ccDisplay= ccDisplay;
		this.icDisplay= icDisplay;
		this.stLabel= stLabel;
		this.noCoinLight = noCoinLight;
	}

	public void setCoin(int coin){
		switch (coin){
		case 50:
			coin50++;
			break;
		case 100:
			coin100++;
			break;
		case 500:
			coin500++;
			break;
		}
		setState();
	}

	public int getAmount(){
		int amount= (coin50)* 50+ (coin100)* 100+ (coin500)* 500;
		return amount;
	}

	public void setState(){
		for (int i= 0; i< station.length; i++){
			station[i].setButtonState(getAmount());
			icDisplay.setAmount(getAmount());

		}
	}

	public void retCoins(){
		coin50= 0;
		coin100= 0;
		coin500= 0;
		ccDisplay.setCharge();
		icDisplay.clear();
		for (int i= 0; i< station.length; i++){
			station[i].clear();
		}
	}

	public void setTicketPrice(boolean isRoundTrip){
		this.isRoundTrip= isRoundTrip;
		for (int i= 0; i< station.length; i++){
			stLabel[i].setPrice(isRoundTrip);
			station[i].setDoublePrice(isRoundTrip);
			station[i].setButtonState(getAmount());
			if (i== station.length- 1){
				stLabel[i+ 1].setPrice(isRoundTrip);
			}
		}
	}

	public void setRoundTrip(boolean isRoundTrip){
		this.isRoundTrip= isRoundTrip;
		setTicketPrice(isRoundTrip);
	}

	public void retOverCoins(int value){
		ccDisplay.setText(""+ value);
	}

	public boolean isRoundTrip(){
		return isRoundTrip;
	}
	public void changeNoCoinLight(){
		for(int i = 0;i<2;i++){
			noCoinLight[i].changeColor();
		}
	}
	
	public void clear(){
		coin50= 0;
		coin100= 0;
		coin500= 0;
		setState();
	}
}
