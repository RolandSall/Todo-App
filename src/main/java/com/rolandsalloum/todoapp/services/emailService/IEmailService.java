package com.rolandsalloum.todoapp.services.emailService;

import com.rolandsalloum.todoapp.models.TodoSuggestion;

public interface IEmailService {

     TodoSuggestion sendMail(TodoSuggestion todoSuggestion);
}
