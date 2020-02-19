package com.fms.controller;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fms.model.MailList;
import com.fms.model.ResponseModel;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/sendEmail")
public class MailController {

	@Autowired
	Environment environment;

	@PostMapping
	public ResponseModel saveFeedback(@RequestBody MailList fModel) {

		// FeedbackScoreEntity savedEntity = feedbackService.save(fModel);
		ResponseModel reModel = new ResponseModel();

		System.out.println(fModel.getEventId() + " " + fModel.getEmployeeId() + " " + fModel.getVolType());

		String eventId = fModel.getEventId();
		String employeeId = fModel.getEmployeeId();
		String volType = fModel.getVolType();
		try {
			sendmail(eventId, employeeId, volType);
			reModel.setMessage("Email sent successfully");
			reModel.setHttpStatus(HttpStatus.OK.value());
			return reModel;
		} catch (Exception e) {
			reModel.setMessage(e.getMessage());
			reModel.setHttpStatus(0);
			return reModel;
		}

	}

	private void sendmail(String event, String employee, String volType) {

		String host = environment.getProperty("application.host");

		String link = "";
		String data = "?eventid=" + event + "&id=" + employee;
		switch (volType) {
		case "va":
			link = host + "/feedback" + data;
			break;
		case "vna":
			link = host + "/nopartfeedback" + data;
			break;
		case "vun":
			link = host + "/unregfeedback" + data;
			break;
		}

		// String to = "717139@cognizant.com";//change accordingly
		String to = environment.getProperty("mail.from");// change accordingly
		String from = environment.getProperty("mail.to");
		;// change accordingly
		String password = environment.getProperty("mail.password");
		;// change accordingly

		// Get the session object
		Properties props = new Properties();
		props.put("mail.smtp.host", environment.getProperty("mail.smtp.host"));
		props.put("mail.smtp.socketFactory.port", environment.getProperty("mail.smtp.socketFactory.port"));
		props.put("mail.smtp.socketFactory.class", environment.getProperty("mail.smtp.socketFactory.class"));
		props.put("mail.smtp.auth", environment.getProperty("mail.smtp.auth"));
		props.put("mail.smtp.port", environment.getProperty("mail.smtp.port"));

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});

		// compose message
		try {
			StringBuilder mailBody = new StringBuilder(environment.getProperty("mail.body1"));
			mailBody.append(environment.getProperty("mail.body2")).append(environment.getProperty("mail.body3"))
					.append(environment.getProperty("mail.body4")).append(environment.getProperty("mail.body5"));

			String mailBodyStr = mailBody.toString().replace("{0}", link);
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Outreach Feedback");
			// message.setText(msg);
			message.setContent(mailBodyStr, "text/html");

			// send message
			// Transport.send(message);
			System.out.println("Email sent successfully");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}
}