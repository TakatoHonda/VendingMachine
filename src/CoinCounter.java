
public class CoinCounter {
	private int coin50;
	private int coin100;
	private int coin500;
	private boolean coinMax;
	
	CoinCounter(){
		coin50 =0;
		coin100=0;
		coin500=0;
		coinMax=false;
	}
	public void coinCount(int coin){
		if(coin50<100 && coin100<100 && coin500<100){
			if(coin == 50){coin50++;}
			if(coin == 100){coin100++;}
			if(coin == 500){coin500++;}
		}else{coinMax = true;}
	}
	public int getAmount(){
		int amount = coin50*50 + coin100*100 + coin500*500;
		return amount;
	}
	public boolean isCoinMax(){
		return coinMax;
	}
	
	
}
