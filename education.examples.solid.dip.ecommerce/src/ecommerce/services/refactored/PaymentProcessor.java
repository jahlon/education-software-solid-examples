package ecommerce.services.refactored;

import ecommerce.interfaces.refactored.IPaymentProcessor;
import ecommerce.model.refactored.PaymentDetails;
import ecommerce.services.PaymentGateway;

public class PaymentProcessor implements IPaymentProcessor {

	@Override
	public void processCreditCard(PaymentDetails paymentDetails, double amount) {
		PaymentGateway paymentGateway = new PaymentGateway();
		paymentGateway.setCardNumber(paymentDetails.getCardNumber());
		paymentGateway.setNameOnCard(paymentDetails.getCardholderName());
		paymentGateway.setExpiresYear(paymentDetails.getExpiresYear());
		paymentGateway.setExpiresMonth(paymentDetails.getExpiresMonth());
		paymentGateway.setAmountToCharge(amount);
		
		paymentGateway.makePayment();

	}

}
