package com.rolandsalloum.todoapp.controllers.EmailController;

import com.rolandsalloum.todoapp.models.TodoSuggestion;
import com.rolandsalloum.todoapp.services.emailService.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/send")
@CrossOrigin
public class TodoSuggestionController {

    private EmailService emailService;

    @Autowired
    public TodoSuggestionController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    public ResponseEntity sendTodoSuggestionViaEmail(@RequestBody TodoSuggestionRequest request){
        try {
            TodoSuggestion todoSuggestion = emailService.sendMail(buildRequest(request));
            return ResponseEntity.status(HttpStatus.OK).body("Email Sent");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    private TodoSuggestion buildRequest(TodoSuggestionRequest request) {
        return new TodoSuggestion().builder()
                .email(request.getEmail())
                .title(request.getTitle())
                .description(request.getDescription())
                .fullName(request.getFullName())
                .build();
    }
}
