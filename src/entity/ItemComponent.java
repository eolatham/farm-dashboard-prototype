package entity;

public abstract class ItemComponent {
  private String name = "Unnamed";
  private int locationX = 0; // feet
  private int locationY = 0; // feet
  private int length = 0; // feet
  private int width = 0; // feet
  private int height = 0; // feet
  private int price = 0; // dollars

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getLocationX() {
    return this.locationX;
  }

  public void setLocationX(int x) {
    this.locationX = x;
  }

  public int getLocationY() {
    return this.locationY;
  }

  public void setLocationY(int y) {
    this.locationY = y;
  }

  public int getLength() {
    return this.length;
  }

  public void setLength(int length) {
    this.length = length;
  }

  public int getWidth() {
    return this.width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getHeight() {
    return this.height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public int getPrice() {
    return this.price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public abstract void addItemComponent(ItemComponent itemComponent);

  public abstract void deleteItemComponent(ItemComponent itemComponent);

  public String toString() {
    return String.format("%s (%s)", getName(), getClass().getSimpleName());
  }
}
