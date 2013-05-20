package machineTest;

import java.io.*;

public class VendingMachine{
	public static int c50= 0;
	public static int c100= 0;
	public static int c500= 0;
	public static int coinAmount= 0;
	public static boolean retFlag= false;
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
	public static boolean[] selFlag= { sel150Flag, sel200Flag, sel450Flag };
	public static boolean no50Flag= false;
	public static boolean no100Flag= false;
	public static int chargeCoin50= 0;
	public static int chargeCoin100= 0;
	public static int chargeCoin500= 0;

	public VendingMachine(){
		System.out.println("VendingMachine start.");
	}

	// ///////////////////////not io/////////////////////////
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
		coinAmount= c50* 50+ c100* 100+ c500* 500;
	}

	public void setReturnCoins(){
		while(coinAmount!=0){
			if (coinAmount- 500>= 0&& c500> 0){
				r500Flag=true;
				c500--;
				chargeCoin500++;
			} else if (coinAmount- 100>= 0&& c100> 0){
				r500Flag=false;
				r100Flag=true;
				c100--;
				chargeCoin100++;
			} else if (coinAmount- 50>= 0&& c50> 0){
				r100Flag = false;
				r50Flag = true;
				c50--;
				chargeCoin50++;
			}else {
				r50Flag = false;
			}
			setAmount();
		}
	}

//	boolean getFlags(String flagName){
	//	if(flagName.equals("r50Flag"))return r50Flag;
	//	if(flagName.equals("r100Flag"))return r100Flag;
	//	if
	//}
	// ////////////////////not io///////////////////////////////

	public void ioC50(){
		if(!judgeError("c50", c50)){
			c50++;
			setAmount();
			System.out.println("coin50 add:"+ c50);
			System.out.println("coinAmount:"+ coinAmount);
		}else{
			System.out.println("Error: " +"sovrFlag="+sovrFlag+" iovrFlag="+iovrFlag);
		}
	}

	public void ioC100(){
		if(!judgeError("c100", c100)){
			c100++;
			setAmount();
			System.out.println("coin100 add:"+ c100);
			System.out.println("coinAmount:"+ coinAmount);
		}else{
			System.out.println("Error: " +"sovrFlag="+sovrFlag+" iovrFlag="+iovrFlag);
		}	
	}

	public void ioC500(){
		if(!judgeError("c500", c500)){
			c500++;
			setAmount();
			System.out.println("coin500 add:"+ c500);
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

	public void ioACK(){
		
	/* (twiceFlag== false){
			for (int i= 0; i< selFlag.length; i++){
				selFlag[i]= false;
			}
		if(coinAmount>1000){
			iovrFlag = true;
		}else{
			iovrFlag = false;
		}
		if(c50>10||c100>10||c500>10){
			sovrFlag=true;
		}else
			sovrFlag= false;
		}*/
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
		if (coinAmount>= 150&& req150Flag== true){
			sel150Flag= true;
			c50--;
			c100--;
			setAmount();
		}
		setReturnCoins();
		return sel150Flag;
	}

	public boolean ioSEL200(){
		if (coinAmount>= 200&& req200Flag== true){
			sel200Flag= true;
			c100-=2;
			setAmount();
		}
		setReturnCoins();
		return sel200Flag;
	}

	public boolean ioSEL450(){
		if (coinAmount>= 450&& req450Flag== true){
			sel450Flag= true;
			c100-=4;
			c50--;
		}
		setReturnCoins();
		return sel450Flag;
	}

	public boolean ioR50(){
		if(chargeCoin50>0){
			chargeCoin50--;
			r50Flag=true;
		}else{
			r50Flag=false;
		}
		return r50Flag;
	}

	public boolean ioR100(){
		setReturnCoins();
		if (chargeCoin100> 0){
			r100Flag= true;
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
