package entity;

import javafx.scene.image.Image;

public class Drone {
  private Image icon;
  private int locationX = 0;
  private int locationY = 0;

  public Drone(String iconFilePath) {
    setIcon(new Image(iconFilePath, 100, 100, true, true));
  }

  public void setIcon(Image icon) {
    this.icon = icon;
  }

  public Image getIcon() {
    return icon;
  }

  public void setLocationX(int x) {
    locationX = x;
  }

  public int getLocationX() {
    return locationX;
  }

  public void setLocationY(int y) {
    locationY = y;
  }

  public int getLocationY() {
    return locationY;
  }
}
