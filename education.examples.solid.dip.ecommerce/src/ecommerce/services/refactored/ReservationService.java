package ecommerce.services.refactored;

import ecommerce.interfaces.refactored.IReservationService;
import ecommerce.model.refactored.Item;
import ecommerce.services.InventorySystem;

public class ReservationService implements IReservationService {

	@Override
	public void reserveInventory(Iterable<Item> items) {
		for(Item item : items) {
			InventorySystem inventorySystem = new InventorySystem();
			inventorySystem.reserve(item.getProduct().getSku(), item.getQuantity());
		}
	}

}
