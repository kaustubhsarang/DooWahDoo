package com.DooWahDoo.Main.Service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Component;

@Component
public class SendEmailService {

	final static String senderEmailID = "dwdtestemail1@gmail.com";
	final static String senderPassword = "DooWahDoo";
	final static String emailSMTPserver = "smtp.gmail.com";
	final static String emailServerPort = "465";

	private final String SUBJECT_TEXT = "Welcome to DooWahDoo";

	public String sendEmail(String receiverEmailID, String firstName) {
		final String BODY_TEXT = setEmailBody(firstName);
		Properties props = new Properties();
		props.put("mail.smtp.user", senderEmailID);
		props.put("mail.smtp.host", emailSMTPserver);
		props.put("mail.smtp.port", emailServerPort);
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.socketFactory.port", emailServerPort);
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");
		SecurityManager security = System.getSecurityManager();
		try {
			Authenticator auth = new SMTPAuthenticator();
			Session session = Session.getInstance(props, auth);
			MimeMessage msg = new MimeMessage(session);
			msg.setText(BODY_TEXT);
			msg.setSubject(SUBJECT_TEXT);
			msg.setFrom(new InternetAddress(senderEmailID));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(receiverEmailID));
			Transport.send(msg);
			System.out.println("Message send Successfully:)");
			return "Sent";
		}

		catch (Exception mex) {
			mex.printStackTrace();
			return "Fail";
		}

	}

	private String setEmailBody(String firstName) {
		return "Welcome " + firstName + "!\r\n" + "\r\n"
				+ "We are so excited to have you. As you know, our mission is to help you have fun at the Karaoke night by helping you flaunt your hidden talent in front of your friends. Yay!\r\n"
				+ "\r\n"
				+ "You have a lot of options to sing from our wide variety of music database with amazing KJ/DJ to accompany you. \r\n"
				+ "\r\n" + "Why to wait, let's sing some songs together!\r\n" + "\r\n" + "Love,\r\n" + "Team DooWahDoo";
	}

	public static class SMTPAuthenticator extends javax.mail.Authenticator {
		public PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(senderEmailID, senderPassword);
		}
	}

}
