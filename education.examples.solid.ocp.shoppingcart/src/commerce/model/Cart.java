package commerce.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	
	private List<commerce.model.refactored.Item> items;

	public Cart() {
		items = new ArrayList<commerce.model.refactored.Item>();
	}
	
	public void addItem(commerce.model.refactored.Item item) {
		item.setNumber(items.size() + 1);
		items.add(item);
	}
	
	public List<commerce.model.refactored.Item> getItems() {
		return items;
	}
	
	public double calculateTotal() {
		double total = 0d;
		for (commerce.model.refactored.Item item : items) {
			total += item.calculateTotal();
		}
		return total;
	}
	
	
}
