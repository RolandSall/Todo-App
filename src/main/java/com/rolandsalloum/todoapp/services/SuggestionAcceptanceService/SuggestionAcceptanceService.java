package com.rolandsalloum.todoapp.services.SuggestionAcceptanceService;

import com.rolandsalloum.todoapp.models.Todo;
import com.rolandsalloum.todoapp.models.TodoSuggestion;
import com.rolandsalloum.todoapp.services.todoService.TodoService;
import com.rolandsalloum.todoapp.services.todoSuggestedService.SuggestedTodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SuggestionAcceptanceService implements ISuggestionAcceptanceService{

    private SuggestedTodoService suggestedTodoService;
    private TodoService todoService;

    @Autowired
    public SuggestionAcceptanceService(SuggestedTodoService suggestedTodoService, TodoService todoService) {
        this.suggestedTodoService = suggestedTodoService;
        this.todoService = todoService;
    }

    @Override
    public Todo setPriorityForSuggestedTodo(UUID suggestedTodoId, String importance) throws Exception {
        TodoSuggestion suggestedTodo = suggestedTodoService.getSuggestedTodoById(suggestedTodoId);
        System.out.println(suggestedTodo);
        Todo todo = buildTodoFromTheSuggestion(suggestedTodo,importance);
        Todo savedTodo = todoService.createTodo(todo);
        return savedTodo;
    }

    private Todo buildTodoFromTheSuggestion(TodoSuggestion suggestedTodo, String importance) {
        return new Todo().builder()
                .isCompleted(false)
                .description(suggestedTodo.getDescription())
                .importance(importance)
                .title(suggestedTodo.getTitle())
                .todoId(UUID.randomUUID())
                .build();
    }
}
