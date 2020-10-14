package entity;

import java.util.ArrayList;

/*
 * Composite design pattern
 */
public class ItemContainer extends ItemComponent {
  private int price = 0; // dollars
  private ArrayList<ItemComponent> components = new ArrayList<ItemComponent>();

  public ItemContainer() {}

  public ItemContainer(String name) {
    setName(name);
  }

  public int getPrice() {
    int total = price;
    for (ItemComponent c : components) total += c.getPrice();
    return total;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public void addItemComponent(ItemComponent itemComponent) {
    this.components.add(itemComponent);
  }

  public void deleteItemComponent(ItemComponent itemComponent) {
    this.components.remove(itemComponent);
  }
}
