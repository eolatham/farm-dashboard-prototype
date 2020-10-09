package composite;

public class Item extends ItemComponent {

	private String name = "New Item";

	@Override
	public void addItemComponent(ItemComponent itemComponent) {
		System.out.println("Cannot add an ItemComponent to an Item!");
	}

	@Override
	public void deleteItemComponent(int index) {
		System.out.println("Cannot delete an ItemComponent from an Item!");
	}

}
