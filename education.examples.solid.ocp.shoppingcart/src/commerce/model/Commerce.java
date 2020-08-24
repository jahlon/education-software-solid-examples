package commerce.model;

public class Commerce {
	
	private Cart cart;
	
	public Commerce() {
		cart = new Cart();
	}
	
	public void addItemToCart(Product product, int quantity) {
		cart.addItem(product, quantity);
	}
	
	public Cart getCart() {
		return cart;
	}
	
}
