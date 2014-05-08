package ecommerce.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import ecommerce.model.PaymentDetails.PaymentMethod;
import ecommerce.services.InventorySystem;
import ecommerce.services.PaymentGateway;

public class Order {
	
	public void checkout(Cart cart, PaymentDetails paymentDetails, boolean notifyCustomer) throws OrderException {
		if(paymentDetails.getPaymentMethod() == PaymentMethod.CREDIT_CARD) {
			chargeCard(paymentDetails, cart);
		}
		
		reserveInventory(cart);
		
		if(notifyCustomer) {
			notifyCustomer(cart);
		}
	}

	private void notifyCustomer(Cart cart) throws OrderException {
		String customerMail = cart.getCustomerEmail();
		if(customerMail != null && !customerMail.isEmpty()) {
			Properties props = new Properties();
			props.setProperty("mail.smtp.host", "localhost");
			Session session = Session.getDefaultInstance(props, null);
			MimeMessage message = new MimeMessage(session);
			try {
				message.setFrom(new InternetAddress("orders@somewhere.com"));
				message.setRecipient(Message.RecipientType.TO, new InternetAddress(customerMail));
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Date date = new Date();
				message.setSubject("Your order place on " + dateFormat.format(date));
				message.setText("Your order details: \n" + cart);
				Transport.send(message);
			} catch (AddressException e) {
				Logger.getGlobal().log(Level.SEVERE, "Problems sending notification: " + e.getMessage());
				e.printStackTrace();
				throw new OrderException();
			} catch (MessagingException e) {
				Logger.getGlobal().log(Level.SEVERE, "Problems sending notification: " + e.getMessage());
				e.printStackTrace();
				throw new OrderException();
			}
		}
	}

	private void reserveInventory(Cart cart) {
		for(Item item : cart.getItems()) {
			InventorySystem inventorySystem = new InventorySystem();
			inventorySystem.reserve(item.getProduct().getSku(), item.getQuantity());
		}
	}

	private void chargeCard(PaymentDetails paymentDetails, Cart cart) {
		PaymentGateway paymentGateway = new PaymentGateway();
		paymentGateway.setCardNumber(paymentDetails.getCardNumber());
		paymentGateway.setNameOnCard(paymentDetails.getCardholderName());
		paymentGateway.setExpiresYear(paymentDetails.getExpiresYear());
		paymentGateway.setExpiresMonth(paymentDetails.getExpiresMonth());
		paymentGateway.setAmountToCharge(paymentDetails.getTotalAmount());
		
		paymentGateway.makePayment();
	}
	
}
