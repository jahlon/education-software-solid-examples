package ecommerce.model.refactored;

import ecommerce.interfaces.refactored.INotificationService;
import ecommerce.interfaces.refactored.IPaymentProcessor;
import ecommerce.interfaces.refactored.IReservationService;

public class OnlineOrder extends Order {
	
	private final INotificationService notificationService;
	private final PaymentDetails paymentDetails;
	private final IReservationService reservationService;
	private final IPaymentProcessor paymentProcessor;
	
	public OnlineOrder(Cart cart, 
						PaymentDetails paymentDetails,
						IPaymentProcessor paymentProcessor,
						IReservationService reservationService,
						INotificationService notificationService) {
		super(cart);
		this.paymentDetails = paymentDetails;
		this.notificationService = notificationService;
		this.reservationService = reservationService;
		this.paymentProcessor = paymentProcessor;
	}

	@Override
	public void checkout() throws OrderException {
		paymentProcessor.processCreditCard(paymentDetails, cart.calculateTotal());
		reservationService.reserveInventory(cart.getItems());
		notificationService.notifyCustomerOrderCreated(cart);
	}

}
