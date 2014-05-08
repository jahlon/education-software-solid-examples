package commerce.model;

public class Item {
	
	private int number;
	private Product product;
	private int quantity;
	
	public Item(Product product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}
	public double calculateTotal() {
		double total = 0d;
		String sku = product.getSku();
		double normalPrice = product.getPrice() * quantity;
		if(sku.startsWith("EA")) { // Normal price
			total = normalPrice;
		} else if (sku.startsWith("WE")) { // Price per kg
			total = normalPrice * 1000d;
		} else if (sku.startsWith("SP")) { // 20% discount for each 3 units up to 50%
			int setsOfThree = quantity / 3;
			total = normalPrice * (1 - (setsOfThree<3 ? 0.2d*setsOfThree : 0.5d));
		}
		// more rules coming...
		return total;
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
