import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailController {
    public static void main(String[] args) {
        String message = "Hello, this is an automated message from your banking system.";
        String subject = "Password Reset";
        String to = "socialhuzefa@gmail.com";
        String from = "codehuzefa@gmail.com";
        
        sendEmail(message, subject, to, from);
    }

    // This method is used for sending the email.
    private static void sendEmail(String message, String subject, String to, String from) {
        // Variable for Gmail.
        String host = "smtp.gmail.com";
        
        // Get the system properties.
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.starttls.enable", "true");

        // Step 1: Create a session.
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, "emvx udym icev cgns");
            }
        });
        
        session.setDebug(true);

        // Step 2: Compose the message.
        MimeMessage m = new MimeMessage(session);
        try {
            // From email.
            m.setFrom(new InternetAddress(from));
        
            // Adding recipient to message.
            m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            
            // Adding subject.
            m.setSubject(subject);
            
            // Adding message.
            m.setText(message);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Step 3: Send the message using Transport class.
        try {
            Transport.send(m);
            System.out.println("Sent successfully!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
