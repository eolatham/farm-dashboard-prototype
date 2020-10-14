package entity;

/*
 * Composite design pattern
 */
public abstract class ItemComponent {
  private String name = "Unnamed";
  private int locationX = 0; // feet
  private int locationY = 0; // feet
  private int length = 0; // feet
  private int width = 0; // feet
  private int height = 0; // feet

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getLocationX() {
    return locationX;
  }

  public void setLocationX(int x) {
    this.locationX = x;
  }

  public int getLocationY() {
    return locationY;
  }

  public void setLocationY(int y) {
    this.locationY = y;
  }

  public int getLength() {
    return length;
  }

  public void setLength(int length) {
    this.length = length;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public abstract int getPrice();

  public abstract void setPrice(int price);

  public abstract void addItemComponent(ItemComponent itemComponent);

  public abstract void deleteItemComponent(ItemComponent itemComponent);

  public String toString() {
    return String.format("%s (%s)", getName(), getClass().getSimpleName());
  }
}
