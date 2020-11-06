package entity;

import java.util.ArrayList;
import javafx.scene.shape.Rectangle;

/*
 * Composite design pattern
 */
public class ItemContainer extends ItemComponent {
  private ArrayList<ItemComponent> components = new ArrayList<ItemComponent>();

  public ItemContainer() {
    rectangle.setOpacity(0.5);
  }

  public ItemContainer(String name) {
    rectangle.setOpacity(0.5);
    setName(name);
  }

  public ArrayList<Rectangle> getRectangles() {
    ArrayList<Rectangle> rectangles = new ArrayList<Rectangle>();
    rectangles.add(getRectangle());
    for (ItemComponent c : components) rectangles.addAll(c.getRectangles());
    return rectangles;
  }

  public int getAggregatePurchasePrice() {
    int total = purchasePrice;
    for (ItemComponent c : components) total += c.getAggregatePurchasePrice();
    return total;
  }

  public void addItemComponent(ItemComponent itemComponent) {
    this.components.add(itemComponent);
  }

  public void deleteItemComponent(ItemComponent itemComponent) {
    this.components.remove(itemComponent);
  }
}
