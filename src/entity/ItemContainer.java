package entity;

import java.util.ArrayList;

/*
 * Composite design pattern
 */
public class ItemContainer extends ItemComponent {
  private ArrayList<ItemComponent> components = new ArrayList<ItemComponent>();

  public ItemContainer() {}

  public ItemContainer(String name) {
    setName(name);
  }

  public void addItemComponent(ItemComponent itemComponent) {
    this.components.add(itemComponent);
  }

  public void deleteItemComponent(ItemComponent itemComponent) {
    this.components.remove(itemComponent);
  }
}
