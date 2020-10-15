package entity;

import java.util.ArrayList;
import javafx.scene.shape.Rectangle;

/*
 * Composite design pattern
 */
public class ItemContainer extends ItemComponent {
  private ArrayList<ItemComponent> components = new ArrayList<ItemComponent>();

  public ItemContainer() {}

  public ItemContainer(String name) {
    setName(name);
  }

  public ArrayList<Rectangle> getRectangles() {
    ArrayList<Rectangle> rectangles = new ArrayList<Rectangle>();
    rectangles.add(getRectangle());
    for (ItemComponent c : components) rectangles.addAll(c.getRectangles());
    return rectangles;
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
