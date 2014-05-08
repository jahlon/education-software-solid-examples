package ecommerce.services.mocks;

import ecommerce.interfaces.refactored.INotificationService;
import ecommerce.model.refactored.Cart;
import ecommerce.model.refactored.OrderException;

public class NotificationServiceMock implements INotificationService {
	
	public boolean wasCalled;
	
	@Override
	public void notifyCustomerOrderCreated(Cart cart) throws OrderException {
		wasCalled = true;
	}

}
