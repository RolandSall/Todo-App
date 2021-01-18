package com.rolandsalloum.todoapp.controllers.SuggestionAcceptanceController;

import com.rolandsalloum.todoapp.models.Todo;
import com.rolandsalloum.todoapp.services.SuggestionAcceptanceService.SuggestionAcceptanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/accept")
public class SuggestionAcceptanceController {


    SuggestionAcceptanceService suggestionAcceptanceService;

    @Autowired
    public SuggestionAcceptanceController(SuggestionAcceptanceService suggestionAcceptanceService) {
        this.suggestionAcceptanceService = suggestionAcceptanceService;
    }



    @PostMapping("/{suggestedTodoId}")
    public ResponseEntity setPriorityForSuggestedTodo(@PathVariable("suggestedTodoId") UUID suggestedTodoId, @RequestBody TodoImportanceRequest todoImportanceRequest) {
        try {
            Todo todo = suggestionAcceptanceService.setPriorityForSuggestedTodo(suggestedTodoId, todoImportanceRequest.getImportance());
            return ResponseEntity.status(HttpStatus.OK).body(todo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

    }
}