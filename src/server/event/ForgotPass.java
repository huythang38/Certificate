/*
 * huythang38
 */
package server.event;

import java.sql.ResultSet;
import java.sql.SQLException;
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
	Statement stmt;
	ResultSet rst;
	int accounts_id;
	String name;
	public Config config = new Config();

	public ForgotPass() {}

	public boolean checkEmail(String email) {
		boolean check = false;
		try {
			stmt = Server.conn.createStatement();
			String sql = "select * from students where email = '" + email
					+ "'";
			rst = stmt.executeQuery(sql);
			if (rst.next()) {
				check = true;
				accounts_id = rst.getInt("accounts_id");
				name = rst.getString("name");
			} else {
				check = false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}

	public void sendPassToMail(String email) {
		String sql = "select * from accounts where id = '" + accounts_id + "'";
		try {
			rst = stmt.executeQuery(sql);
			rst.next();

			try {
				sendMail(rst.getString("password"), email);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sendMail(String pass, String to) throws Exception {
		String from = config.getUser_smtp();
		
		Properties props = System.getProperties();
		// –
		props.put("mail.smtp.host", config.getSmtp());
		props.put("mail.smtp.port", config.getPort_smtp());
		props.put("mail.smtp.starttls.enable", "true");
		
		final String login = from;// ”nth001@gmail.com”;//usermail
		final String pwd = config.getPass_smtp();// ”password cua ban o day”;
		Authenticator pa = null; // default: no authentication
		
		if (login != null && pwd != null) { // authentication required?
			props.put("mail.smtp.auth", "true");
			pa = new Authenticator() {
				public PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(login, pwd);
				}
			};
			
		}// else: no authentication
		Session session = Session.getInstance(props, pa);
		// — Create a new message –
		Message msg = new MimeMessage(session);
		// — Set the FROM and TO fields –
		msg.setFrom(new InternetAddress(from));
		msg.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(to, false));

		// — Set the subject and body text –
		msg.setSubject("Certificate Center: Forgot Password!");
		msg.setText("Dear " + name + ",\n\n" +
				"\t This is your password: " + pass + "\n\n" +
				"Thank you,\n" +
				"Certificate Center!");
		
		// — Set some other header information –
		msg.setHeader("X-Mailer", "LOTONtechEmail");
		msg.setSentDate(new Date());
		msg.saveChanges();
		// — Send the message –
		Transport.send(msg);
		System.out.println("Message sent OK.");

	}
}
