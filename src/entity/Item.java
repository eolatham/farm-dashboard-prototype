package entity;

public class Item extends ItemComponent {

  public Item() {}

  public Item(String name) {
    setName(name);
  }

  public void addItemComponent(ItemComponent itemComponent) {
    System.out.println("Cannot add an ItemComponent to an Item!");
  }

  public void deleteItemComponent(ItemComponent itemComponent) {
    System.out.println("Cannot delete an ItemComponent from an Item!");
  }
}
