package entity;

/*
 * Composite design pattern
 */
public class Item extends ItemComponent {
  private int price = 0; // dollars

  public Item() {}

  public Item(String name) {
    setName(name);
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public void addItemComponent(ItemComponent itemComponent) {
    System.out.println("Cannot add an ItemComponent to an Item!");
  }

  public void deleteItemComponent(ItemComponent itemComponent) {
    System.out.println("Cannot delete an ItemComponent from an Item!");
  }
}
