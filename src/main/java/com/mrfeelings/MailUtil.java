package com.mrfeelings;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.mrfeelings.Config.PropKey;
import com.mrfeelings.db.DataException;
import com.mrfeelings.db.entities.User;

public class MailUtil {

  private static final boolean DEBUG = false;

  private static class SMTPAuthenticator extends javax.mail.Authenticator {
    @Override public PasswordAuthentication getPasswordAuthentication() {
      String username = Config.getValue(PropKey.smtpAuthUsername);
      String password = Config.getValue(PropKey.smtpAuthPassword);
      return new PasswordAuthentication(username, password);
    }
  }
  
  public static void sendMail(User sender, String subject, String body) throws DataException {
    try {
      //Set the host smtp address
      Properties props = new Properties();
      props.put("mail.smtp.host", Config.getValue(PropKey.smtpServer));
      props.put("mail.smtp.auth", "true");

      Authenticator auth = new SMTPAuthenticator();

      // create some properties and get the default Session
      Session session = Session.getDefaultInstance(props, auth);
      session.setDebug(DEBUG);
  
      // create a message
      Message msg = new MimeMessage(session);
  
      // set the from and to address
      InternetAddress addressFrom = new InternetAddress(sender.getEmail());
      msg.setFrom(addressFrom);
  
      InternetAddress[] addressTo = new InternetAddress[]{
          new InternetAddress(Config.getValue(PropKey.happyCoupleEmail)) };
      msg.setRecipients(Message.RecipientType.TO, addressTo);
  
      // Setting the Subject and Content Type
      msg.setSubject(subject);
      msg.setContent(body, "text/plain");
      Transport.send(msg);
    }
    catch (AddressException e) {
      throw new DataException(e);
    }
    catch (MessagingException e) {
      throw new DataException(e);
    }
  }
}
