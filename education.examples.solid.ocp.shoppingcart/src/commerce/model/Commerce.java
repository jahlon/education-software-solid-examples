package commerce.model;

public class Commerce {
	
	private Cart cart;
	
	public Commerce() {
		cart = new Cart();
	}
	
	public void addItemToCart(Product product, int quantity) {
		commerce.model.refactored.Item item = new commerce.model.refactored.Item(product, quantity);
		cart.addItem(item);
	}
	
	public Cart getCart() {
		return cart;
	}
	
}
