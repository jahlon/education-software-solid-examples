package ecommerce.model.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ecommerce.model.Cart;
import ecommerce.model.Order;
import ecommerce.model.OrderException;
import ecommerce.model.PaymentDetails;
import ecommerce.model.PaymentDetails.PaymentMethod;

public class OrderCheckoutTest {

	private Order order;
	private Cart cart;
	private PaymentDetails paymentDetails;
	
	@Before
	public void setUp() throws Exception {
		order = new Order();
		cart = new Cart();
		paymentDetails = new PaymentDetails();
	}

	@Test
	public void testNotFailWithNoItemsNoNotificationNoCreditCard() {
		paymentDetails.setPaymentMethod(PaymentMethod.CASH);
		boolean shouldNotifyCustomer = false;
		try {
			order.checkout(cart, paymentDetails, shouldNotifyCustomer);
		} catch (OrderException e) {
			fail("Exception caught: " + e.getMessage());
		}
		// If it got here, it worked
	}
	
	@Test
	public void testNotFailWithNoItemsNotificationNoCreditCard() {
		cart.setCustomerEmail("someone@nowhere.com");
		paymentDetails.setPaymentMethod(PaymentMethod.CASH);
		boolean shouldNotifyCustomer = true;
		try {
			order.checkout(cart, paymentDetails, shouldNotifyCustomer);
		} catch (OrderException e) {
			e.printStackTrace();
			fail("Exceptin caught: " + e.getMessage());
		}
	}
	
	

}
