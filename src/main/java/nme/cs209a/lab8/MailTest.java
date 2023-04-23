package nme.cs209a.lab8;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;
import java.util.Scanner;
import jakarta.mail.Authenticator;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;


public class MailTest {
  public static void main(String[] args) throws MessagingException, IOException {
    // read properties
    Properties props = new Properties();
    try (InputStream in = MailTest.class.getResourceAsStream("/cs209a/lab8/mail.properties")) {
      props.load(in);
    }

    String subject;
    StringBuilder builder = new StringBuilder();
    // read message info
    try (Scanner sc = new Scanner(Objects.requireNonNull(MailTest.class.getResourceAsStream("/cs209a/lab8/message.txt")))) {
      subject = sc.nextLine();

      while (sc.hasNextLine()) {
        builder.append(sc.nextLine()).append("\n");
      }
    }

    String email = props.getProperty("mail.user");
    String password = props.getProperty("mail.password");
    InternetAddress from = new InternetAddress(props.getProperty("mail.from"));
    InternetAddress to = new InternetAddress(props.getProperty("mail.to"));

    Session session = Session.getInstance(props, new Authenticator() {
      @Override
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(email, password);
      }
    });

    MimeMessage message = new MimeMessage(session);
    message.setFrom(from);
    message.setRecipient(MimeMessage.RecipientType.TO, to);
    message.setSubject(subject);
    message.setText(builder.toString());

    Transport.send(message);
  }
}