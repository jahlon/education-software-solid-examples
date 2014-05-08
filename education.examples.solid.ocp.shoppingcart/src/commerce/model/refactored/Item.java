package commerce.model.refactored;

import commerce.model.Product;

public class Item {
	
	private int number;
	private Product product;
	private int quantity;
	private IPricingCalculator pricingCalculator;
		
	public Item(Product product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
		pricingCalculator = new PricingCalculator(); // Should use IOC
	}
	public double calculateTotal() {
		return pricingCalculator.calculatePrice(product, quantity);
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
}
