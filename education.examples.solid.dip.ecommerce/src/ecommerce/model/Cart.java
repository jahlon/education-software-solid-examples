package ecommerce.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	
	private List<Item> items;
	private String customerEmail;
	
	public Cart() {
		items = new ArrayList<Item>();
	}

	public List<Item> getItems() {
		return items;
	}

	public void addItem(Item item) {
		items.add(item);
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	
}
