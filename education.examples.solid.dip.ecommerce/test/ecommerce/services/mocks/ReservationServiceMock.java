package ecommerce.services.mocks;

import ecommerce.interfaces.refactored.IReservationService;
import ecommerce.model.refactored.Item;

public class ReservationServiceMock implements IReservationService {
	
	public boolean wasCalled;

	@Override
	public void reserveInventory(Iterable<Item> items) {
		wasCalled = true;
	}

}
