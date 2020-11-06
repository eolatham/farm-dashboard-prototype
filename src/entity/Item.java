package entity;

import java.lang.UnsupportedOperationException;
import java.util.ArrayList;
import javafx.scene.shape.Rectangle;

/*
 * Composite design pattern
 */
public class Item extends ItemComponent {
  private int marketValue = 0; // dollars

  public Item() {
    rectangle.setOpacity(0.5);
  }

  public Item(String name) {
    rectangle.setOpacity(0.5);
    setName(name);
  }

  public ArrayList<Rectangle> getRectangles() {
    ArrayList<Rectangle> rectangles = new ArrayList<Rectangle>();
    rectangles.add(getRectangle());
    return rectangles;
  }

  public int getAggregatePurchasePrice() {
    return getPurchasePrice();
  }

  public void setMarketValue(int marketValue) {
    this.marketValue = marketValue;
  }

  public int getMarketValue() {
    return marketValue;
  }

  public void addItemComponent(ItemComponent itemComponent)
    throws UnsupportedOperationException {
    throw new UnsupportedOperationException(
      "Cannot add an ItemComponent to an Item!"
    );
  }

  public void deleteItemComponent(ItemComponent itemComponent)
    throws UnsupportedOperationException {
    throw new UnsupportedOperationException(
      "Cannot delete an ItemComponent from an Item!"
    );
  }

  public ArrayList<ItemComponent> getComponents()
    throws UnsupportedOperationException {
    throw new UnsupportedOperationException(
      "Cannot get components of an Item!"
    );
  }
}
