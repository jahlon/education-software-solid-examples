package ecommerce.model.refactored;

public class OrderException extends Exception {

	private static final long serialVersionUID = 5215774017071977327L;

	public OrderException(String msg, Throwable e) {
		super(msg, e); 
	}
}
