package entity;

import java.util.ArrayList;

public class ItemContainer extends ItemComponent {

	private String name = "New Item Container";
	private ArrayList<ItemComponent> components = new ArrayList<ItemComponent>();

	@Override
	public void addItemComponent(ItemComponent itemComponent) {
		this.components.add(itemComponent);
	}

	@Override
	public void deleteItemComponent(int index) {
		this.components.remove(index);
	}
}
