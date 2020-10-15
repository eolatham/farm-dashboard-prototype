package entity;

import java.lang.UnsupportedOperationException;

import javafx.scene.shape.Rectangle;

/*
 * Composite design pattern
 */
public class Item extends ItemComponent {
  private int price = 0; // dollars

  public Item(Rectangle rectangle) {
	  setRectangle(rectangle);
  }

  public Item(String name, Rectangle rectangle) {
    setName(name);
    setRectangle(rectangle);
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
