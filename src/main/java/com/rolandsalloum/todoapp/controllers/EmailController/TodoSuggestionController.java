package com.rolandsalloum.todoapp.controllers.EmailController;

import com.rolandsalloum.todoapp.services.emailService.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/send")
public class TodoSuggestionController {

    private EmailService emailService;

    @Autowired
    public TodoSuggestionController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping
    public String sendTodoSuggestionViaEmail(){
        return "Testing Email Controller";
    }
}
