package com.rolandsalloum.todoapp.services.emailService;

import com.rolandsalloum.todoapp.models.TodoSuggestion;

public interface IEmailService {

     void sendMail(TodoSuggestion todoSuggestion);
}
