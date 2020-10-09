package singleton;

import composite.ItemContainer;

public class Dashboard {

	private static Dashboard instance = null;
	public ItemContainer itemContainer;

	private Dashboard() {
	itemContainer = new ItemContainer();
	}

	public static Dashboard getInstance() {
	if (instance == null) {
		instance = new Dashboard();
	}
	return instance;
	}
}
