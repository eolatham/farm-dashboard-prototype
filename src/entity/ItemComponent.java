package entity;

import java.lang.UnsupportedOperationException;

import javafx.scene.shape.Rectangle;

/*
 * Composite design pattern
 */
public abstract class ItemComponent {
  private String name = "Unnamed";
  private int locationX = 0; // feet
  private int locationY = 0; // feet
  private int length = 0; // feet
  private int width = 0; // feet
  private int height = 0; // feet
  private Rectangle rectangle = null;

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setLocationX(int x) {
    this.locationX = x;
  }

  public int getLocationX() {
    return locationX;
  }

  public void setLocationY(int y) {
    this.locationY = y;
  }

  public int getLocationY() {
    return locationY;
  }

  public void setLength(int length) {
    this.length = length;
  }

  public int getLength() {
    return length;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getWidth() {
    return width;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public int getHeight() {
    return height;
  }

  public void setRectangle(Rectangle rectangle) {
	  this.rectangle = rectangle;
  }

  public Rectangle getRectangle() {
	  return rectangle;
  }

  public abstract void setPrice(int price);

  public abstract int getPrice();

  public abstract int getAggregatePrice();

  public abstract void addItemComponent(ItemComponent itemComponent)
    throws UnsupportedOperationException;

  public abstract void deleteItemComponent(ItemComponent itemComponent)
    throws UnsupportedOperationException;

  public String toString() {
    return String.format("%s (%s)", getName(), getClass().getSimpleName());
  }
}
