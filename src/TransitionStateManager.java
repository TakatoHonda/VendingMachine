
public class TransitionStateManager{
	private int coin50;
	private int coin100;
	private int coin500;
	private boolean isRoundTrip;
	private DispAmount dspInput;
	private DispAmount dspCharge;
	private StationButton[] station;
	private StationLabel[] stLabel;
	private NoCoinLight[] noCoinLight;
	private ConfirmWindow confirmWindow;
 	TransitionStateManager(DispAmount dspInput, DispAmount dspCharge, StationButton[] station, StationLabel[] stLabel){
		coin50 = 0;
		coin100= 0;
		coin500= 0;
		this.station = station;
		this.dspInput = dspInput;
		this.dspCharge = dspCharge;
		this.stLabel = stLabel;
	}
 	public void showConfirmWindow(StationButton station){
 		confirmWindow.setVisible(station);
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
		int amount = (coin50)*50 + (coin100)*100 + (coin500)*500;
		return amount;
	}
	public void setState(){
		for(int i=0;i<station.length;i++){
			station[i].setButtonState(getAmount());
			dspInput.setAmount(getAmount());
			dspCharge.setCharge();
			
		}
	}
	public void setButtonState(StationButton station){
		
	}
	public void setTicketPrice(boolean isRoundTrip){
		this.isRoundTrip = isRoundTrip;
		for(int i=0;i<station.length;i++){
			stLabel[i].setPrice(isRoundTrip);
			station[i].setDoublePrice(isRoundTrip);
			if(i==station.length-1){stLabel[i+1].setPrice(isRoundTrip);}
		}
		setState();
	}
	public void setRoundTrip(boolean isRoundTrip){
		this.isRoundTrip = isRoundTrip;
		setTicketPrice(isRoundTrip);
	}
	public void retOverCoins(int value){
		dspCharge.setText(""+value);
		dspInput.setText(Integer.toString(getAmount()-value));
	}
	public boolean isRoundTrip(){
		return isRoundTrip;
	}
	public void clear(){
		coin50 = 0;
		coin100= 0;
		coin500= 0;
		setState();
	}	
}