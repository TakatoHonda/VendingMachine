package machineTest;

import java.io.*;

public class VendingMachine{
	private static final int defCoin = 5;
	public static int innerCoin50= defCoin;
	public static int innerCoin100= defCoin;
	public static int innerCoin500= defCoin;
	public static int c50= 0;
	public static int c100= 0;
	public static int c500= 0;
	public static int coinAmount= 0;
	public static boolean iovrFlag= false;
	public static boolean sovrFlag= false;
	public static boolean r50Flag= false;
	public static boolean r100Flag= false;
	public static boolean r500Flag= false;
	public static boolean req150Flag= false;
	public static boolean req200Flag= false;
	public static boolean req450Flag= false;
	public static boolean twiceFlag= false;
	public static boolean sel150Flag= false;
	public static boolean sel200Flag= false;
	public static boolean sel450Flag= false;
	public static boolean no50Flag= false;
	public static boolean no100Flag= false;
	public static int chargeCoin50= 0;
	public static int chargeCoin100= 0;
	public static int chargeCoin500= 0;

	public VendingMachine(){
		System.out.println("VendingMachine start.");
	}

	/////////////////////////not io/////////////////////////
	public boolean judgeError(String coin, int num){
		//System.out.println("judgeError() start.");
		if (coin.equals("c50")){
			iovrFlag = (coinAmount+50)> 1000 ? true:false;
		} else if (coin.equals("c100")){
			iovrFlag = (coinAmount+100)> 1000 ? true:false;
		} else if (coin.equals("c500")){
			iovrFlag = (coinAmount+500)> 1000? true:false;
		}
		sovrFlag = (num >= 10) ? true:false;
		return (sovrFlag || iovrFlag);
	}

	public void setAmount(){
		coinAmount= (c50)* 50+ (c100)* 100+ (c500)* 500;
	}

	public void setReturnCoins(){
		while(coinAmount!=0){
			if (coinAmount- 500>= 0&& innerCoin50> 0){
				r500Flag=true;
				c500--;
				innerCoin500--;
				chargeCoin500++;
			} else if (coinAmount- 100>= 0&& innerCoin100> 0){
				r500Flag=false;
				r100Flag=true;
				c100--;
				innerCoin100--;
				chargeCoin100++;
			} else if (coinAmount- 50>= 0&& innerCoin500> 0){
				r100Flag = false;
				r50Flag = true;
				c50--;
				innerCoin50--;
				chargeCoin50++;
			}else {
				r50Flag = false;
				sel150Flag=false;
				sel200Flag=false;
				sel450Flag=false;
			}
			setAmount();
		}
	}
	
	////////////////////////not io///////////////////////////////

	public void ioC50(){
		if(!judgeError("c50", innerCoin50)){
			c50++;
			innerCoin50++;
			setAmount();
			System.out.println("coin50 add:"+ c50);
			System.out.println("total:"+innerCoin50);
			System.out.println("coinAmount:"+ coinAmount);
		}else{
			System.out.println("Error: " +"sovrFlag="+sovrFlag+" iovrFlag="+iovrFlag);
		}
	}

	public void ioC100(){
		if(!judgeError("c100", innerCoin100)){
			c100++;
			innerCoin100++;
			setAmount();
			System.out.println("coin100 add:"+ c100);
			System.out.println("total:"+innerCoin100);
			System.out.println("coinAmount:"+ coinAmount);
		}else{
			System.out.println("Error: " +"sovrFlag="+sovrFlag+" iovrFlag="+iovrFlag);
		}	
	}

	public void ioC500(){
		if(!judgeError("c500", innerCoin500)){
			c500++;
			innerCoin500++;
			setAmount();
			System.out.println("coin500 add:"+ c500);
			System.out.println("total:"+innerCoin500);
			System.out.println("coinAmount:"+ coinAmount);
		}else{
			System.out.println("Error: " +"sovrFlag="+sovrFlag+" iovrFlag="+iovrFlag);
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

	public void ioACK(){}

	public void ioSTB(){
	}

	public boolean ioIOVR(){
		return iovrFlag;
	}

	public boolean ioSOVR(){
		return sovrFlag;
	}

	public boolean ioSEL150(){
		if (coinAmount>= 150&& req150Flag== true){
			sel150Flag= true;
			c50--;
			c100--;
			innerCoin50--;
			innerCoin100--;
			setAmount();
			System.out.println("io sel150 coinAmount:"+coinAmount);
			if(!twiceFlag)setReturnCoins();
		}else if(coinAmount < 150){
			sel150Flag = false;
			setReturnCoins();
			twiceFlag = false;
		}
		return sel150Flag;
	}

	public boolean ioSEL200(){
		if (coinAmount>= 200&& req200Flag== true){
			sel200Flag= true;
			c100--;
			c100--;
			innerCoin100-=2;
			setAmount();
			System.out.println("io sel200 coinAmount:"+coinAmount);
		}else if(coinAmount < 200){
			sel200Flag = false;
			setReturnCoins();
			twiceFlag = false;
		}
		return sel200Flag;
		}

	public boolean ioSEL450(){
		if (coinAmount>= 450&& req450Flag== true){
			sel450Flag= true;
			c50--;
			c100--;
			c100--;
			c100--;
			c100--;
			innerCoin100-=4;
			innerCoin50--;
			setAmount();
			System.out.println("io sel450 coinAmount:"+coinAmount);
			if(!twiceFlag){}
		}else if(coinAmount < 450){
			sel450Flag = false;
			setReturnCoins();
			twiceFlag = false;
		}
		return sel450Flag;
	}

	public boolean ioR50(){
		if(chargeCoin50>0){
			chargeCoin50--;
			r50Flag=true;
			System.out.println("r50flag changed true.");
		}else{
			r50Flag=false;
		}
		return r50Flag;
	}

	public boolean ioR100(){
		setReturnCoins();
		if (chargeCoin100> 0){
			r100Flag= true;
			System.out.println("r100flag changed true.");
			chargeCoin100--;
		} else{
			r100Flag= false;
		}
		return r100Flag;
	}

	public boolean ioR500(){
		setReturnCoins();
		if (chargeCoin500> 0){
			r500Flag= true;
			System.out.println("r500flag changed true.");
			chargeCoin500--;
		} else{
			r500Flag= false;
		}
		return r500Flag;
	}

	public boolean ioNO50(){
		if (c50== 0){
			no50Flag= true;
		}
		return no50Flag;
	}

	public boolean ioNO100(){
		if (c100== 0){
			no100Flag= true;
		}
		return no100Flag;
	}

	public void ioInit(){
	}

}