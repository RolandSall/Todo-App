package com.rolandsalloum.todoapp.services.emailService;

import com.rolandsalloum.todoapp.models.TodoSuggestion;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EmailService implements IEmailService{

    public static final String DEFAULT_EMAIL_SENTENCE = "Hello There, I am reaching out to you to suggest the following todo: ";
    public static final String ROLAND_TODO_EMAIL = "roland@todo.com";
    private JavaMailSenderImpl javaMailSender;
    private EmailConfig emailConfig;




    public EmailService(JavaMailSenderImpl javaMailSender, EmailConfig emailConfig) {
        this.javaMailSender = javaMailSender;
        this.emailConfig = emailConfig;
    }

    @Override
    public TodoSuggestion sendMail(TodoSuggestion todoSuggestion) {
        configureEmailProperties();
        sendEmail(todoSuggestion);
        todoSuggestion.setTodoId(UUID.randomUUID());
        return todoSuggestion;
    }

    private void sendEmail(TodoSuggestion todoSuggestion) {
        var mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(todoSuggestion.getEmail());
        mailMessage.setSubject(todoSuggestion.getTitle());
        mailMessage.setText(DEFAULT_EMAIL_SENTENCE + todoSuggestion.getDescription());
        mailMessage.setTo(ROLAND_TODO_EMAIL);
        javaMailSender.send(mailMessage);
    }

    private void configureEmailProperties() {
        javaMailSender.setHost(emailConfig.getHost());
        javaMailSender.setPort(emailConfig.getPort());
        javaMailSender.setUsername(emailConfig.getUsername());
        javaMailSender.setPassword(emailConfig.getPassword());
    }
}
