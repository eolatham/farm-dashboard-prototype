package entity;

import java.lang.UnsupportedOperationException;
import java.util.ArrayList;
import javafx.scene.shape.Rectangle;

/*
 * Composite design pattern
 */
public class Item extends ItemComponent {

  public Item() {}

  public Item(String name) {
    setName(name);
  }

  public ArrayList<Rectangle> getRectangles() {
    ArrayList<Rectangle> rectangles = new ArrayList<Rectangle>();
    rectangles.add(getRectangle());
    return rectangles;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getPrice() {
    return price;
  }

  public int getAggregatePrice() {
    return getPrice();
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
}
