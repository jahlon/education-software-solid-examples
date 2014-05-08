package ecommerce.services;

public class PaymentGateway {
	private String cardNumber;
	private int expiresMonth;
	private int expiresYear;
	private String nameOnCard;
	private double amountToCharge;
	
	public void makePayment() {
		// Do the payment process
		System.out.println("Making payment");
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
	public String getNameOnCard() {
		return nameOnCard;
	}
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}
	public double getAmountToCharge() {
		return amountToCharge;
	}
	public void setAmountToCharge(double amountToCharge) {
		this.amountToCharge = amountToCharge;
	}
	
	
}
