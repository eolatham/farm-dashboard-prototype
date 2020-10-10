package entity;

import java.util.ArrayList;

public class ItemContainer extends ItemComponent {
  private ArrayList<ItemComponent> components = new ArrayList<ItemComponent>();

  public ItemContainer() {}

  public ItemContainer(String name) {
    setName(name);
  }

  public void addItemComponent(ItemComponent itemComponent) {
    this.components.add(itemComponent);
  }

  public void deleteItemComponent(int index) {
    this.components.remove(index);
  }
}
