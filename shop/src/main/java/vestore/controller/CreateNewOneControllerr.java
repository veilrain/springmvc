package vestore.controller;

import java.util.Properties;
import java.util.UUID;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vestore.model.User;

@Controller
public class CreateNewOneControllerr {
	@RequestMapping("/createNewOne")
	public String createNewOne(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "users/createNewOne";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@ModelAttribute("user") User user, Model model) throws AddressException, MessagingException {
		String s = UUID.randomUUID().toString();
		String code = s.substring(0, 5);
		sendMail(user, code);

		model.addAttribute("code", code);
		return "registerSuccess";
	}

	private boolean sendMail(User user, String code) throws AddressException, MessagingException {
		Properties props = new Properties();
		props.put("username", user.getEmailAddress());
		props.put("mail.smtp.host", "smtp.126.com");//TODO
		props.put("mail.smtp.auth", "true");
		Session mailSession = Session.getDefaultInstance(props);
		Message msg = new MimeMessage(mailSession);
		msg.setFrom(new InternetAddress("@126.com"));//TODO
		msg.setRecipient(Message.RecipientType.TO, new InternetAddress("lay123111@126.com"));
		msg.setSubject("register");
		msg.setContent("Mail test:" + code, "text/html;charset=UTF-8");
		msg.saveChanges();

		Transport tran = mailSession.getTransport("smtp");
		tran.connect("email", "password");//TODO
		tran.sendMessage(msg, msg.getAllRecipients());
		return true;
	}

}
