

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class StationButton extends JButton implements MouseListener{
	ImageIcon buttonLight = new ImageIcon("./img/stationIcon.gif");
	private String name;
	private String route;
	private int    price;
	private boolean isRoundTripFlag = false;
	//private int posX,posY;

	private DispAmount    dspCharge;
	private TransitionState   transitionState;
	private VendingMachine vm;
	private VendGui gui;
	
	public static class Builder{
		private int cnt=0;
		private String name;
		private String route;
		private int    price;
		private int    posX,posY;

		private DispAmount     dspCharge;
		private TransitionState    transitionState;
		private VendingMachine vm;
		private VendGui        gui;
		public Builder(DispAmount dspCharge, TransitionState transitionState, VendingMachine vm, VendGui gui){
			this.dspCharge = dspCharge;
			this.transitionState = transitionState;
			this.vm = vm;
			this.gui = gui;
		}
		public Builder name(String name){
			this.name = name;
			return this;
		}
		public Builder route(String route){
			this.route = route;
			cnt++;
			return this;
		}
		public Builder price(int price){
			this.price = price;
			cnt++;
			return this;
		}
		public Builder posX(int posX){
			this.posX = posX;
			cnt++;
			return this;
		}
		public Builder posY(int posY){
			this.posY = posY;
			cnt++;
			return this;
		}
		public StationButton build(){
			if(cnt<4) throw new IllegalStateException("Error. Argument is not enough.");{
			return new StationButton(this);
			}
		}
	}
	StationButton(Builder builder){
		this.setEnabled(false);
		name = builder.name;
		price = builder.price;
		route = builder.route;
		transitionState = builder.transitionState;
		dspCharge = builder.dspCharge;
		vm = builder.vm;
		gui = builder.gui;
		this.setBounds(builder.posX, builder.posY, 30, 30);
		this.setIcon(buttonLight);
	}
	public void setButtonState(int amount){
		if ((price <= amount) && (this.isEnabled() == false)){
			this.setEnabled(true);
			addMouseListener(this);
		} else if ((price >= amount) && (this.isEnabled() == true)){
			this.setEnabled(false);
			removeMouseListener(this);
		}
	}
	public void setDoublePrice(boolean isRoundTrip){
		if (isRoundTrip){
			price *= 2;
		} else{
			price /= 2;
		}
	}
	public void setRoundTrip(boolean isRoundTripFlag){
		this.isRoundTripFlag = isRoundTripFlag;
	}
	public String getName(){
		return name;
	}
	public int getPrice(){
		return price;
	}
	public String getRoute(){
		return route;
	}
	public boolean isRoundTrip(){
		return isRoundTripFlag;
	}
	public void mouseClicked(MouseEvent e){
			ConfirmWindow confirmWindow = new ConfirmWindow(this, dspCharge, transitionState, vm, gui);
			confirmWindow.setVisible(true);
	}

	public void mouseEntered(MouseEvent e){
	}

	public void mousePressed(MouseEvent e){
	}

	public void mouseReleased(MouseEvent e){
	}

	public void mouseExited(MouseEvent e){
	}

}
