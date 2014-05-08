package ecommerce.interfaces.refactored;

import ecommerce.model.refactored.PaymentDetails;

public interface IPaymentProcessor {
	
	public void processCreditCard(PaymentDetails paymentDetails, double amount);
	
}
