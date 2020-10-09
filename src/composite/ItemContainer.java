package composite;

import java.util.ArrayList;

public class ItemContainer extends ItemComponent {

	private String name = "New Item Container";
    private int locationX = 0;  // feet
    private int locationY = 0;  // feet
    private int length = 10;  // feet
    private int width = 10;  // feet
    private int height = 10;  // feet
    private double price = 10.0;  // dollars
	private ArrayList<ItemComponent> components = new ArrayList<ItemComponent>();

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int getLocationX() {
		return this.locationX;
	}

	@Override
	public void setLocationX(int x) {
		this.locationX = x;
	}

	@Override
	public int getLocationY() {
		return this.locationY;
	}

	@Override
	public void setLocationY(int y) {
		this.locationY = y;

	}

	@Override
	public int getLength() {
		return this.length;
	}

	@Override
	public void setLength(int length) {
		this.length = length;
	}

	@Override
	public int getWidth() {
		return this.width;
	}

	@Override
	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	public int getHeight() {
		return this.height;
	}

	@Override
	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public double getPrice() {
		return this.price;
	}

	@Override
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public void addItem(ItemComponent item) {
		this.components.add(item);
	}

	@Override
	public void deleteItem(int index) {
		this.components.remove(index);
	}

	@Override
	public void addItemContainer(ItemComponent itemContainer) {
		this.components.add(itemContainer);
	}

	@Override
	public void deleteItemContainer(int index) {
		this.components.remove(index);
	}
}
