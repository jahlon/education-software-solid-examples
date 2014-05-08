package ecommerce.model.refactored;

public class PaymentDetails {
	
	public enum PaymentMethod {
		CREDIT_CARD,
		DEBIT_CARD,
		PAYPAL,
		CASH
	}
	
	private PaymentMethod paymentMethod;
	
	private String cardNumber;
	private int expiresMonth;
	private int expiresYear;
	private String cardholderName;

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getExpiresMonth() {
		return expiresMonth;
	}

	public void setExpiresMonth(int expiresMonth) {
		this.expiresMonth = expiresMonth;
	}

	public int getExpiresYear() {
		return expiresYear;
	}

	public void setExpiresYear(int expiresYear) {
		this.expiresYear = expiresYear;
	}

	public String getCardholderName() {
		return cardholderName;
	}

	public void setCardholderName(String cardholderName) {
		this.cardholderName = cardholderName;
	}
}
