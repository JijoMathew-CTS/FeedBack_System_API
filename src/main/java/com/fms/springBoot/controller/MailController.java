package com.fms.springBoot.controller;
import java.util.Properties; 
import javax.mail.*; 
import javax.mail.internet.*;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fms.springBoot.Model.MailList;
import com.fms.springBoot.Model.ResponseModel;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/sendEmail")
public class MailController{ 

	   
	  public static String host="http://localhost:4200";
//	   @Autowired
//		private FeedbackService feedbackService;

		@PostMapping
		public ResponseModel saveFeedback(@RequestBody MailList fModel) {

			//FeedbackScoreEntity savedEntity = feedbackService.save(fModel);
			ResponseModel reModel = new ResponseModel();

			System.out.println(fModel.getEventId()+" "+fModel.getEmployeeId()+" "+fModel.getVolType());
			
			String eventId		= fModel.getEventId();
			String employeeId	= fModel.getEmployeeId();
			String volType		= fModel.getVolType();
				try {
					sendmail(eventId,employeeId,volType);
					reModel.setMessage("Email sent successfully");
					reModel.setHttpStatus(HttpStatus.OK.value());
					return reModel;
				}
				catch(Exception e) {
					reModel.setMessage(e.getMessage());
					reModel.setHttpStatus(0);
					return reModel;
				}

		}
	   
	   private void sendmail(String event,String employee,String volType){
		   String link="";
		   String data="?eventid="+event+"&id="+employee;
		   switch (volType) {
			case "va":
				link = host+"/feedback"+data;
				break;
			case "vna":
				link = host+"/nopartfeedback"+data;
				break;
			case "vun":
				link = host+"/unregfeedback"+data;
				break;
			}
		   
		   //String to		= "717139@cognizant.com";//change accordingly
		   String to		= "bijobca@gmail.com";//change accordingly
		   String from		= "bijockbaby@gmail.com";//change accordingly 
		   String password	= "9645221155";//change accordingly 

		   	//Get the session object 
			Properties props = new Properties(); 
			props.put("mail.smtp.host", "smtp.gmail.com"); 
			props.put("mail.smtp.socketFactory.port", "465"); 
			props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory"); 
			props.put("mail.smtp.auth", "true"); 
			props.put("mail.smtp.port", "465"); 
			
			Session session = Session.getDefaultInstance(props, 
				new javax.mail.Authenticator() { 
					protected PasswordAuthentication getPasswordAuthentication() { 
						return new PasswordAuthentication(from,password);
					} 
				}
			); 

			//compose message 
			try { 
			
				String	msg=	"<html>";
						msg=msg+"<body>";
						msg=msg+"<div style='margin: 5% 10%;background: antiquewhite;width:80%;border: solid white;'>";
						msg=msg+"<div style='padding: 5%;background-color:white;border: solid white;width: 80%;margin: 5%;'>";
						msg=msg+"<p>Hi,</p>";
						msg=msg+"<p>&emsp;&emsp; Thank you for become an volunteer with us. Please tell us about the experiance as feedback. Your feedback help us to create a better experiance to you and all of our volunteer.</p>";
						msg=msg+"<p style='text-align: center'>";
						msg=msg+"<a href=\""+link+"\" target=\"_blank\"";
						msg=msg+"style=\" background-color: #4CAF50;color: white;	padding: 10px 20px;	text-align: center; text-decoration: none;	display: inline-block;\">Send Your feedback</a>";
						msg=msg+"</p>";
						msg=msg+"</div>";
						msg=msg+"</div>";
						msg=msg+"</body>";
						msg=msg+"</html>";

			MimeMessage message = new MimeMessage(session); 
			message.setFrom(new InternetAddress(from)); 
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(to)); 
			message.setSubject("Outreach Feedback"); 
			//message.setText(msg);
			message.setContent(msg, "text/html");
			
			//send message 
			//Transport.send(message); 
			System.out.println("Email sent successfully");
			
			} catch (MessagingException e) {
				throw new RuntimeException(e);
			} 
			
			} 
}