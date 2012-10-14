/*
 * huythang38
 */
package server.event;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import server.Server;
import server.config.Config;

public class ForgotPass {
	/**
	 * @uml.property  name="stmt"
	 */
	Statement stmt;
	/**
	 * @uml.property  name="rst"
	 */
	ResultSet rst;
	/**
	 * @uml.property  name="accounts_id"
	 */
	int accounts_id;
	/**
	 * @uml.property  name="name"
	 */
	String name;
	/**
	 * @uml.property  name="config"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	public Config config = new Config();

	public ForgotPass() {
	}

	public boolean checkEmail(String email) {
		boolean check = false;
			if (Server.studentsTable.getEmail(email) != null) {
				check = true;
				accounts_id = Server.studentsTable.getAccounts_id(email);
				name = Server.studentsTable.getName(email);
			} else {
				check = false;
			}
		return check;
	}

	public void sendPassToMail(String email) {
		String pass = Server.accountsTable.getUsername(accounts_id);
		if (!pass.equals("")) {
			try {
				sendMail(pass, email);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void sendMail(String pass, String to) throws Exception {
		String from = config.getUser_smtp();

		Properties props = System.getProperties();
		// â€“
		props.put("mail.smtp.host", config.getSmtp());
		props.put("mail.smtp.port", config.getPort_smtp());
		props.put("mail.smtp.starttls.enable", "true");

		final String login = from;
		final String pwd = config.getPass_smtp();
		Authenticator pa = null;

		if (login != null && pwd != null) { // authentication required?
			props.put("mail.smtp.auth", "true");
			pa = new Authenticator() {
				public PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(login, pwd);
				}
			};

		}// else: no authentication
		Session session = Session.getInstance(props, pa);
		// â€” Create a new message â€“
		Message msg = new MimeMessage(session);
		// â€” Set the FROM and TO fields â€“
		msg.setFrom(new InternetAddress(from));
		msg.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(to, false));

		// â€” Set the subject and body text â€“
		msg.setSubject("Certificate Center: Forgot Password!");
		msg.setText("Dear " + name + ",\n\n" + "\t This is your password: "
				+ pass + "\n\n" + "Thank you,\n" + "Certificate Center!");

		// â€” Set some other header information â€“
		msg.setHeader("X-Mailer", "LOTONtechEmail");
		msg.setSentDate(new Date());
		msg.saveChanges();
		// â€” Send the message â€“
		Transport.send(msg);
		System.out.println("Message sent OK.");

	}
}
