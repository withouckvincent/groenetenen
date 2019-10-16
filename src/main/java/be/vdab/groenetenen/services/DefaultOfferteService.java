package be.vdab.groenetenen.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.groenetenen.entities.Offerte;
import be.vdab.groenetenen.mail.MailSender;
import be.vdab.groenetenen.messaging.OfferteEnOffertesURL;
import be.vdab.groenetenen.repositories.OfferteRepository;

@Service
@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
class DefaultOfferteService implements OfferteService {
	private final OfferteRepository offerteRepository;
	private final MailSender mailSender;

	private final JmsTemplate jmsTemplate;
	private final String nieuweOfferteQueue;

	/*
	 * DefaultOfferteService(OfferteRepository offerteRepository, MailSender
	 * mailSender) { this.offerteRepository = offerteRepository; this.mailSender =
	 * mailSender; }
	 */

	DefaultOfferteService(OfferteRepository offerteRepository, MailSender mailSender, JmsTemplate jmsTemplate,
			@Value("${nieuweOfferteQueue}") String nieuweOfferteQueue) {
		this.offerteRepository = offerteRepository;
		this.mailSender = mailSender;
		this.jmsTemplate = jmsTemplate;
		this.nieuweOfferteQueue = nieuweOfferteQueue;
	}

	// @Override
	// @Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED)
	/*
	 * public void create(Offerte offerte) { offerteRepository.save(offerte);
	 * mailSender.nieuweOfferte(offerte); }
	 */
	/*
	 * public void create(Offerte offerte, String offertesURL) {
	 * offerteRepository.save(offerte); mailSender.nieuweOfferte(offerte,
	 * offertesURL); }
	 */

	@Override
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED)
	public void create(Offerte offerte, String offertesURL) {
		offerteRepository.save(offerte);
		OfferteEnOffertesURL offerteEnOffertesURL = new OfferteEnOffertesURL(offerte, offertesURL);
		jmsTemplate.convertAndSend(nieuweOfferteQueue, offerteEnOffertesURL);
	}

	@Override
	@Scheduled(/* cron = " 0 0/1 * 1/1 * ? * " */ fixedRate = 60000)
	// test = om de minuut
	public void aantalOffertesMail() {
		mailSender.aantalOffertesMail(offerteRepository.count());
	}

}
