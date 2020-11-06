package entity;

import java.lang.UnsupportedOperationException;
import java.util.ArrayList;
import javafx.scene.shape.Rectangle;

/*
 * Composite design pattern
 */
public abstract class ItemComponent {
  protected String name = "Unnamed";
  protected int locationX = 0; // feet
  protected int locationY = 0; // feet
  protected int length = 0; // feet
  protected int width = 0; // feet
  protected int height = 0; // feet
  protected Rectangle rectangle = new Rectangle(0, 0, 0, 0); // 2D representation
  protected int purchasePrice = 0; // dollars

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setLocationX(int x) {
    locationX = x;
    rectangle.setX(x);
  }

  public int getLocationX() {
    return locationX;
  }

  public void setLocationY(int y) {
    locationY = y;
    rectangle.setY(y);
  }

  public int getLocationY() {
    return locationY;
  }

  public void setLength(int length) {
    this.length = length;
    rectangle.setHeight(length);
  }

  public int getLength() {
    return length;
  }

  public void setWidth(int width) {
    this.width = width;
    rectangle.setWidth(width);
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

  public Rectangle getRectangle() {
    return rectangle;
  }

  public abstract ArrayList<Rectangle> getRectangles();

  public void setPurchasePrice(int purchasePrice) {
    this.purchasePrice = purchasePrice;
  }

  public int getPurchasePrice() {
    return purchasePrice;
  }

  public abstract void setMarketValue(int marketValue)
    throws UnsupportedOperationException;

  public abstract int getMarketValue() throws UnsupportedOperationException;

  public abstract void addItemComponent(ItemComponent itemComponent)
    throws UnsupportedOperationException;

  public abstract void deleteItemComponent(ItemComponent itemComponent)
    throws UnsupportedOperationException;

  public abstract ArrayList<ItemComponent> getComponents()
    throws UnsupportedOperationException;

  public String toString() {
    return String.format("%s (%s)", getName(), getClass().getSimpleName());
  }

  public void acceptVisitor(ItemComponentVisitor visitor) {
    visitor.visit(this);
  }
}
