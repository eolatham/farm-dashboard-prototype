package entity;

import java.lang.UnsupportedOperationException;

/*
 * Composite design pattern
 */
public class Item extends ItemComponent {
  private int price = 0; // dollars

  public Item() {}

  public Item(String name) {
    setName(name);
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getPrice() {
    return price;
  }

  public int getAggregatePrice() throws UnsupportedOperationException {
    throw new UnsupportedOperationException(
      "Cannot get aggregate price of an Item!"
    );
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
