public class CoinCounter {
	private int coin50;
	private int coin100;
	private int coin500;
	private boolean coinMaxFlag;
	DispAmount dispValue;
	CoinCounter(){
		coin50 =5;
		coin100=5;
		coin500=5;
		coinMaxFlag=false;
	}
	public void setCoin(int coin){
		if(coin50<100 && coin100<100 && coin500<100){
			if(coin == 50){coin50++;}
			if(coin == 100){coin100++;}
			if(coin == 500){coin500++;}
		}else{coinMaxFlag = true;}
		
		
	}
	public int getAmount(){
		int amount = (coin50-5)*50 + (coin100-5)*100 + (coin500-5)*500;
		return amount;
	}
	public boolean isCoinMax(){
		return coinMaxFlag;
	}
	public void clear(){
		coin50  = 5;
		coin100 = 5;
		coin500 = 5;
		coinMaxFlag = false;
	}
	public int getCoin50() {return  coin50;}
	public int getCoin100(){return coin100;}
	public int getCoin500(){return coin500;}
	
	
}
