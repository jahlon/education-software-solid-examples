package ecommerce.services.mocks;

import ecommerce.interfaces.refactored.IPaymentProcessor;
import ecommerce.model.refactored.PaymentDetails;

public class PaymentProcessorMock implements IPaymentProcessor {
	
	public double amountPassed;
	public boolean wasCalled = false;
	
	@Override
	public void processCreditCard(PaymentDetails paymentDetails, double amount) {
		wasCalled = true;
		amountPassed = amount;
	}

}
