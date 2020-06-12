package pl.bs.paintmysite.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.bs.paintmysite.controllers.msg.EmailMsg;
import pl.bs.paintmysite.controllers.msg.UserMsg;
import pl.bs.paintmysite.models.User;
import pl.bs.paintmysite.repositories.UserRepository;
import javax.mail.*;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User get() {
        return userRepository.findById(0L).orElseThrow(() -> new RuntimeException("There is no admin data in db"));
    }

    public void update(UserMsg userMsg) {
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(userMsg, User.class);
        user.setId(0L);
        userRepository.save(user);
    }

    public void sendEmail(EmailMsg emailMsg) {

        String adminEmail = userRepository.findById(0L).get().getEmail();

        // Recipient's email ID needs to be mentioned.
        String to = adminEmail;

        // Sender's email ID needs to be mentioned
        String from = emailMsg.getEmail();

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("paint.my.site.notification@gmail.com", System.getenv("EMAIL_PASSWORD"));

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("Paint-my-site: Message from " + emailMsg.getName());

            // Now set the actual message
            message.setText("Message from " + emailMsg.getEmail() + ":\n\n" + emailMsg.getMessage());

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

        System.out.println("Email sent!");
    }

}


