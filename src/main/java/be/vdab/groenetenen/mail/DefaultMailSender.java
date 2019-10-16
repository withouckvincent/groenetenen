package be.vdab.groenetenen.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import be.vdab.groenetenen.entities.Offerte;
import be.vdab.groenetenen.exceptions.KanMailNietZendenException;

@Component
public class DefaultMailSender implements MailSender {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private final JavaMailSender sender;

	DefaultMailSender(JavaMailSender sender) {
		this.sender = sender;
	}

	/*
	 * @Override public void nieuweOfferte(Offerte offerte) { try {
	 * SimpleMailMessage message = new SimpleMailMessage();
	 * message.setTo(offerte.getEmailAdres()); message.setSubject("Nieuwe offerte");
	 * message.setText("Uw offerte heeft het nummer " + offerte.getId());
	 * //sender.send(message); } catch (MailException ex) {
	 * logger.error("Kan mail nieuwe offerte niet versturen", ex); throw new
	 * KanMailNietZendenException(); } }
	 */

	@Override
	@Async
	public void nieuweOfferte(Offerte offerte, String offertesURL) {
		try {
			MimeMessage message = sender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message);
			helper.setTo(offerte.getEmailAdres());
			helper.setSubject("Nieuwe offerte");
			String offerteURL = offertesURL + offerte.getId();
			helper.setText("Uw offerte heeft het nummer <strong>" + offerte.getId()
					+ "</strong>. Je vindt de offerte <a href='" + offerteURL + "'>hier</a>.", true);
			//sender.send(message);  // Werkt niet wegens ssl probleem
		} catch (MessagingException | MailException ex) {
			logger.error("Kan mail nieuwe offerte niet versturen", ex);
			throw new KanMailNietZendenException();
		}
	}

}
