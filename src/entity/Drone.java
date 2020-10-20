package entity;

import javafx.scene.image.Image;

public class Drone {
	
	private Image icon;
	private int locationX = 100;
	private int locationY = 100;

	public Drone(String iconFilePath) {
		setIcon(new Image(iconFilePath, 100, 100, true, true));
	}
	
	public void setIcon(Image icon) {
		this.icon = icon;
	}
	
	public Image getIcon() {
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

