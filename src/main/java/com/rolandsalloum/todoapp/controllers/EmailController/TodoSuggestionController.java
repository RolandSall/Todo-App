package com.rolandsalloum.todoapp.controllers.EmailController;

import com.rolandsalloum.todoapp.controllers.TodoController.TodoApiResponse;
import com.rolandsalloum.todoapp.controllers.TodoController.TodoApiUpdateRequest;
import com.rolandsalloum.todoapp.models.Todo;
import com.rolandsalloum.todoapp.models.TodoSuggestion;
import com.rolandsalloum.todoapp.services.emailService.EmailService;
import com.rolandsalloum.todoapp.services.todoSuggestedService.SuggestedTodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/send")
@CrossOrigin
public class TodoSuggestionController {

    private EmailService emailService;
    private SuggestedTodoService suggestedTodoService;

    @Autowired
    public TodoSuggestionController(EmailService emailService, SuggestedTodoService suggestedTodoService) {
        this.emailService = emailService;
        this.suggestedTodoService = suggestedTodoService;
    }

    @PostMapping
    public ResponseEntity sendTodoSuggestionViaEmail(@RequestBody TodoSuggestionRequest request){
        try {
            TodoSuggestion todoSuggestion = emailService.sendMail(buildRequest(request));
            suggestedTodoService.createSuggestedTodo(todoSuggestion);
            return ResponseEntity.status(HttpStatus.OK).body("Email Sent");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity getAllSuggestedTodos(){
        try {
            List<TodoSuggestion> todoList = suggestedTodoService.getAllSuggestedTodos();
            List<SuggestedTodoApiResponse> todoListResponse= buildListOfResponseFrom(todoList);
            return ResponseEntity.status(HttpStatus.OK).body(todoListResponse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/{suggestedTodoId}")
    public ResponseEntity getTodoById(@PathVariable("suggestedTodoId") UUID suggestedTodoId){
        try {
            TodoSuggestion todoSuggestion = suggestedTodoService.getSuggestedTodoById(suggestedTodoId);
            SuggestedTodoApiResponse response = buildSingleSuggestedTodoResponse(todoSuggestion);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/{suggestedTodoId}")
    public ResponseEntity deleteTodoById(@PathVariable("suggestedTodoId") UUID suggestedTodoId){
        try {
            suggestedTodoService.deleteSuggestedTodoById(suggestedTodoId);
            return ResponseEntity.status(HttpStatus.OK).body(suggestedTodoId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/{suggestedTodoId}")
    public ResponseEntity deleteTodoById(@PathVariable("suggestedTodoId") UUID todoId, @RequestBody SuggestedTodoUpdateRequest request){
        try {
            suggestedTodoService.updateSuggestedTodoById(todoId,buildTodoFromUpdateRequest(request));
            return  ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    private TodoSuggestion buildTodoFromUpdateRequest(SuggestedTodoUpdateRequest request) {
        return new TodoSuggestion().builder()
                .email(request.getEmail())
                .title(request.getTitle())
                .description(request.getDescription())
                .fullName(request.getFullName())
                .build();
    }

    private List<SuggestedTodoApiResponse> buildListOfResponseFrom(List<TodoSuggestion> todoSuggestionList) {
        List<SuggestedTodoApiResponse> responseList = new ArrayList<>();
        for (TodoSuggestion todoSuggestion : todoSuggestionList) {
            responseList.add(buildSingleSuggestedTodoResponse(todoSuggestion));
        }
        return responseList;

    }

    private SuggestedTodoApiResponse buildSingleSuggestedTodoResponse(TodoSuggestion todoSuggestion) {
        return new SuggestedTodoApiResponse().builder()
                .suggestedTodoId(todoSuggestion.getSuggestedTodoId())
                .description(todoSuggestion.getDescription())
                .email(todoSuggestion.getEmail())
                .fullName(todoSuggestion.getEmail())
                .title(todoSuggestion.getTitle())
                .build();
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
