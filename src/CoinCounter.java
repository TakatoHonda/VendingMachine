
public class CoinCounter {
	private int coin50;
	private int coin100;
	private int coin500;
	private boolean coinMaxFlag;
	DispAmount dispValue;
	CoinCounter(DispAmount dispValue){
		coin50 =0;
		coin100=0;
		coin500=0;
		coinMaxFlag=false;
		this.dispValue = dispValue;
	}
	public void setCoin(int coin){
		if(coin50<100 && coin100<100 && coin500<100){
			if(coin == 50){coin50++;}
			if(coin == 100){coin100++;}
			if(coin == 500){coin500++;}
		}else{coinMaxFlag = true;}
		
	}
	public int getAmount(){
		int amount = coin50*50 + coin100*100 + coin500*500;
		return amount;
	}
	public boolean isCoinMax(){
		return coinMaxFlag;
	}
	public void clear(){
		coin50 = 0;
		coin100 = 0;
		coin500 = 0;
		coinMaxFlag = false;
	}
}
