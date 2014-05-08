package ecommerce.interfaces.refactored;

import ecommerce.model.refactored.Cart;
import ecommerce.model.refactored.OrderException;

public interface INotificationService {
	
	public void notifyCustomerOrderCreated(Cart cart) throws OrderException;
	
}
