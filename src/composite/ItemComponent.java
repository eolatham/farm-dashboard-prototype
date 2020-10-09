package composite;

public abstract class ItemComponent {
	public abstract String getName();
	public abstract void setName(String name);
	public abstract int getLocationX();
	public abstract void setLocationX(int x);
	public abstract int getLocationY();
	public abstract void setLocationY(int y);
	public abstract int getLength();
	public abstract void setLength(int length);
	public abstract int getWidth();
	public abstract void setWidth(int width);
	public abstract int getHeight();
	public abstract void setHeight(int height);
	public abstract double getPrice();
	public abstract void setPrice(double price);
	public abstract void addItem(ItemComponent item);
	public abstract void deleteItem(int index);
	public abstract void addItemContainer(ItemComponent itemContainer);
	public abstract void deleteItemContainer(int index);
}
