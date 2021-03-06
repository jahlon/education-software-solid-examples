package ecommerce.services.refactored;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import ecommerce.interfaces.refactored.INotificationService;
import ecommerce.model.refactored.Cart;
import ecommerce.model.refactored.OrderException;

public class NotificationService implements INotificationService {

	@Override
	public void notifyCustomerOrderCreated(Cart cart) throws OrderException {
		String customerMail = cart.getCustomerEmail();
		if(customerMail != null && !customerMail.isEmpty()) {
			Properties props = new Properties();
			props.setProperty("mail.smtp.host", "localhost");
			props.setProperty("mail.smtp.port", "2525");
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
			} catch (MessagingException e) {
				e.printStackTrace();
				throw new OrderException("Problems sending notification", e);
			}

		}
	}
}
