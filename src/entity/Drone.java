package entity;

public class Drone {
	
	private String icon = "Null";
	private int locationX = 0;
	private int locationY = 0;


	public void setIcon(String icon) {
		this.icon = icon;
}
	public String getIcon() {
		return icon;
	}
	
	public int getLocationX() {
		return locationX;
	}
	
	public void setLocationX(int x) {
		this.locationX = x;
	}
	
	public int getLocationY() {
		return locationY;
	}
	
	public void setLocationY(int y) {
		this.locationY = y;
	}
}

