package commerce.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	
	private List<commerce.model.refactored.Item> items;

	public Cart() {
		items = new ArrayList<>();
	}
	
	public void addItem(Product product, int quantity) {
		commerce.model.refactored.Item item = new commerce.model.refactored.Item(product, quantity);
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
