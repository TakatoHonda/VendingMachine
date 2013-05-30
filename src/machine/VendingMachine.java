package machine;

public class VendingMachine{
	private static final int DEF_COIN= 50;
	public static int innerCoin50= DEF_COIN;
	public static int innerCoin100= DEF_COIN;
	public static int innerCoin500= DEF_COIN;
	public static final int COIN_MAX= 100;
	public static int c50= 0;
	public static int c100= 0;
	public static int c500= 0;
	public static int coinAmount= 0;
	public static boolean iovrFlag= false;
	public static boolean sovrFlag= false;
	public static boolean req150Flag= false;
	public static boolean req200Flag= false;
	public static boolean req450Flag= false;
	public static boolean sel150Flag= false;
	public static boolean sel200Flag= false;
	public static boolean sel450Flag= false;
	public static boolean notSelFlag= false;
	public static boolean twiceFlag= false;
	public static int chargeCoin50= 0;
	public static int chargeCoin100= 0;
	public static int chargeCoin500= 0;
	public static int chargeAmount= 0;

	public VendingMachine(){
		System.out.println("VendingMachine start.");
	}

	// ///////////////////////not IO/////////////////////////
	public boolean isError(String coin, int num){
		// System.out.println("isError() start.");
		if (coin.equals("c50")){
			iovrFlag= (coinAmount+ 50)> 1000 ? true:false;
		} else if (coin.equals("c100")){
			iovrFlag= (coinAmount+ 100)> 1000 ? true:false;
		} else if (coin.equals("c500")){
			iovrFlag= (coinAmount+ 500)> 1000 ? true:false;
		}
		sovrFlag= (num>= COIN_MAX) ? true:false;
		return (sovrFlag|| iovrFlag);
	}

	public void setAmount(){
		coinAmount= (c50)* 50+ (c100)* 100+ (c500)* 500;
	}

	public void setReturnCoins(){
		while (!(coinAmount== 0)){
			if (coinAmount- 500>= 0){
				innerCoin500--;
				chargeCoin500++;
				coinAmount-= 500;
			} else if (coinAmount- 100>= 0&& innerCoin100> 0){
				innerCoin100--;
				chargeCoin100++;
				coinAmount-= 100;
			} else if (coinAmount- 50>= 0&& innerCoin50> 0){
				innerCoin50--;
				chargeCoin50++;
				coinAmount-= 50;
			} else{
				System.err.println("Error noCoin");
				setChargeAmount();
				coinAmount= chargeAmount;
				innerCoin50+= chargeCoin50;
				innerCoin100+= chargeCoin100;
				innerCoin500+= chargeCoin500;
				chargeCoin50= 0;
				chargeCoin100= 0;
				chargeCoin500= 0;
				req150Flag= false;
				req200Flag= false;
				req450Flag= false;
				sel150Flag= false;
				sel200Flag= false;
				sel450Flag= false;
				notSelFlag= true;
				setAmount();
				setReturnCoins();
				break;
			}
			setChargeAmount();
		}
		if (coinAmount== 0){
			req150Flag= false;
			req200Flag= false;
			req450Flag= false;
			c50= 0;
			c100= 0;
			c500= 0;
			setAmount();
		}
	}

	public void setChargeAmount(){
		chargeAmount= chargeCoin50* 50+ chargeCoin100* 100+ chargeCoin500* 500;
	}

	// //////////////////////notIO//////////////////////////////////

	public void ioC50(){
		if (!isError("c50", innerCoin50)){
			c50++;
			innerCoin50++;
			setAmount();
			System.out.println("coin50 add:"+ c50);
			System.out.println("total:"+ innerCoin50);
			System.out.println("coinAmount:"+ coinAmount);
		} else{
			System.err.println("Error: "+ "sovrFlag="+ sovrFlag+ " iovrFlag="+ iovrFlag);
		}
	}

	public void ioC100(){
		if (!isError("c100", innerCoin100)){
			c100++;
			innerCoin100++;
			setAmount();
			System.out.println("coin100 add:"+ c100);
			System.out.println("total:"+ innerCoin100);
			System.out.println("coinAmount:"+ coinAmount);
		} else{
			System.err.println("Error: "+ "sovrFlag="+ sovrFlag+ " iovrFlag="+ iovrFlag);
		}
	}

	public void ioC500(){
		if (!isError("c500", innerCoin500)){
			c500++;
			innerCoin500++;
			setAmount();
			System.out.println("coin500 add:"+ c500);
			System.out.println("total:"+ innerCoin500);
			System.out.println("coinAmount:"+ coinAmount);
		} else{
			System.err.println("Error: "+ "sovrFlag="+ sovrFlag+ " iovrFlag="+ iovrFlag);
		}
	}

	public void ioREQ150(){
		req150Flag= true;
	}

	public void ioREQ200(){
		req200Flag= true;
	}

	public void ioREQ450(){
		req450Flag= true;
	}

	public void ioTWICE(){
		twiceFlag= true;
	}

	public void ioRET(){
		setReturnCoins();
	}

	public void ioRST(){
	}

	public void ioACK(){
	}

	public void ioSTB(){
	}

	public boolean ioIOVR(){
		return iovrFlag;
	}

	public boolean ioSOVR(){
		return sovrFlag;
	}

	public boolean ioSEL150(){
		sel150Flag=true;
		if (req150Flag== true&& coinAmount>= 150){
			coinAmount-= 150;
			if (!twiceFlag) setReturnCoins();
			return sel150Flag;
		} else if (coinAmount< 150){
			setReturnCoins();
		}
		return false;
	}

	public boolean ioSEL200(){
		sel200Flag=true;
		if (coinAmount>= 200&& req200Flag== true){
			coinAmount-= 200;
			if (!twiceFlag) setReturnCoins();
			return sel200Flag;
		} else if (coinAmount< 200){
			setReturnCoins();
		}
		return false;
	}

	public boolean ioSEL450(){
		sel450Flag=true;
		if (coinAmount>= 450&& req450Flag== true){
			coinAmount-= 450;
			if (!twiceFlag) setReturnCoins();
			return sel450Flag;
		} else if (coinAmount< 450){
			setReturnCoins();
		}
		return false;
	}

	public boolean ioNotSel(){
		return false;
	}
	public boolean ioR50(){
		setReturnCoins();
		if (chargeCoin50> 0){
			chargeCoin50--;
			return true;
		}
		return false;
	}

	public boolean ioR100(){
		setReturnCoins();
		if (chargeCoin100> 0){
			chargeCoin100--;
			return true;
		}
		return false;
	}

	public boolean ioR500(){
		setReturnCoins();
		if (chargeCoin500> 0){
			chargeCoin500--;
			return true;
		}
		return false;
	}

	public boolean ioNO50(){
		if (innerCoin50== 0){ return true; }
		return false;
	}

	public boolean ioNO100(){
		if (innerCoin100== 0){ return true; }
		return false;
	}

	public void ioInit(){
	}

	public void ioClose(){
		System.out.println("VendingMachine end.");
	}

}
