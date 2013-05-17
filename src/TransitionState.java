public class TransitionState{
	private int coin50;
	private int coin100;
	private int coin500;
	DispAmount dspInput;
	StationButton[] station;
	NoCoinLight[] noCoinLight;

	TransitionState(DispAmount dspInput, StationButton[] station){
		this.dspInput= dspInput;
		this.station= station;
		coin50 = 0;
		coin100= 0;
		coin500= 0;
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
		}
	}
	public void clear(){
		coin50 = 0;
		coin100= 0;
		coin500= 0;
		setState();
	}	
}
