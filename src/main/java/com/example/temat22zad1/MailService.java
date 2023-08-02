package com.example.temat22zad1;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    private final JavaMailSender javaMailSender;

    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    private final Logger logger = LoggerFactory.getLogger(MailService.class);

    public void sendEmail(String receiver, String subject, String content) {
        try {
            logger.info("Wysyłam wiadomość");
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper =  new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setFrom("bootcamp@spoko.pl");
            helper.setTo("bootcamp@spoko.pl");
            helper.setSubject(subject + ", Email: " + receiver);
            helper.setText(content, true);
            javaMailSender.send(helper.getMimeMessage());
        } catch (MessagingException e) {
            logger.warn("BŁĄD - nie udało się wysłać wiadomości");
        }
        logger.info("wiadomość wysłana");
        confirmationEmail(receiver, subject);
    }

    private void confirmationEmail(String receiver, String subject) {
        try {
            logger.info("Wysyłam potwierdzenie wiadomość");
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper =  new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setFrom("bootcamp@spoko.pl");
            helper.setTo(receiver);
            helper.setSubject("Potwierdzenie otrzymania wiadomości w sprawie " + subject);
            helper.setText(getConfirmationMessage(), true);
            javaMailSender.send(helper.getMimeMessage());
        } catch (MessagingException e) {
            logger.warn("BŁĄD - nie udało się wysłać potwierdzenia wiadomości");
        }
        logger.info("potwierdzenie wiadomości wysłane");
    }

    private static String getConfirmationMessage() {
        return """
                Dzień dobry.
                Dziękujemy za wiadomość.
                Niedługo otrzymasz od nas odpowiedz.
                Pozdrawiamy
                """;
    }
}
