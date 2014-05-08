package ecommerce.model.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ecommerce.interfaces.refactored.INotificationService;
import ecommerce.interfaces.refactored.IReservationService;
import ecommerce.model.refactored.Cart;
import ecommerce.model.refactored.OnlineOrder;
import ecommerce.model.refactored.Order;
import ecommerce.model.refactored.OrderException;
import ecommerce.model.refactored.PaymentDetails;
import ecommerce.model.refactored.PaymentDetails.PaymentMethod;
import ecommerce.services.mocks.NotificationServiceMock;
import ecommerce.services.mocks.PaymentProcessorMock;
import ecommerce.services.mocks.ReservationServiceMock;
import ecommerce.services.refactored.NotificationService;

public class OnlineOrderCheckoutTest {
	
	private Cart cart;
	private PaymentDetails paymentDetails;
	
	@Before
	public void setUp() throws Exception {
		cart = new Cart();
		paymentDetails = new PaymentDetails();
	}

	@Test
	public void testSendTotalAmountToCreditCardProcessor() throws OrderException {
		PaymentProcessorMock paymentProcessor = new PaymentProcessorMock();
		IReservationService reservationService = new ReservationServiceMock();
		INotificationService notificationService = new NotificationServiceMock();
		paymentDetails.setPaymentMethod(PaymentMethod.CREDIT_CARD);
		Order order = new OnlineOrder(cart,
										paymentDetails,
										paymentProcessor,
										reservationService,
										notificationService);
		order.checkout();
		
		assertTrue(paymentProcessor.wasCalled);
		assertEquals(cart.calculateTotal(), paymentProcessor.amountPassed, 0);		
	}
	
	@Test
	public void testNotFailWithNoItemsNotificationNoCreditCard() throws OrderException {
		PaymentProcessorMock paymentProcessor = new PaymentProcessorMock();
		IReservationService reservationService = new ReservationServiceMock();
		INotificationService notificationService = new NotificationService();
		cart.setCustomerEmail("someone@nowhere.com");
		paymentDetails.setPaymentMethod(PaymentMethod.CASH);
		
		Order order = new OnlineOrder(cart,
										paymentDetails,
										paymentProcessor,
										reservationService,
										notificationService);
		order.checkout();
	}

}
