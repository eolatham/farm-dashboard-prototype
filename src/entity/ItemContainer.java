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

  public void setMarketValue(int marketValue)
    throws UnsupportedOperationException {
    throw new UnsupportedOperationException(
      "Cannot set the marketValue of an ItemContainer!"
    );
  }

  public int getMarketValue() throws UnsupportedOperationException {
    throw new UnsupportedOperationException(
      "Cannot get the marketValue of an ItemContainer!"
    );
  }

  public void addItemComponent(ItemComponent itemComponent) {
    this.components.add(itemComponent);
  }

  public void deleteItemComponent(ItemComponent itemComponent) {
    this.components.remove(itemComponent);
  }

  public ArrayList<ItemComponent> getComponents()
    throws UnsupportedOperationException {
    return components;
  }
}
