package com.rolandsalloum.todoapp.services.emailService;

import com.rolandsalloum.todoapp.models.TodoSuggestion;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements IEmailService{

    private JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendMail(TodoSuggestion todoSuggestion) {
        var mailMessage = new SimpleMailMessage();

        mailMessage.setTo("roland");
        mailMessage.setSubject(todoSuggestion.getTitle());
        mailMessage.setText(todoSuggestion.getDescription());

        mailMessage.setFrom(todoSuggestion.getEmail());

        javaMailSender.send(mailMessage);
    }
}
