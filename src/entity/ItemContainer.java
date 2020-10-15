package entity;

import java.util.ArrayList;

import javafx.scene.shape.Rectangle;

/*
 * Composite design pattern
 */
public class ItemContainer extends ItemComponent {
  private int price = 0; // dollars
  private ArrayList<ItemComponent> components = new ArrayList<ItemComponent>();

  public ItemContainer(Rectangle rectangle) {
	setRectangle(rectangle);
  }

  public ItemContainer(String name, Rectangle rectangle) {
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
    int total = price;
    for (ItemComponent c : components) total += c.getAggregatePrice();
    return total;
  }

  public void addItemComponent(ItemComponent itemComponent) {
    this.components.add(itemComponent);
  }

  public void deleteItemComponent(ItemComponent itemComponent) {
    this.components.remove(itemComponent);
  }
}
