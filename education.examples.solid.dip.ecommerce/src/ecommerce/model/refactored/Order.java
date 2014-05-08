package ecommerce.model.refactored;

public abstract class Order {
	
	protected final Cart cart;
	
	protected Order(Cart cart) {
		this.cart = cart;
	}
	
	public abstract void checkout() throws OrderException;
}
