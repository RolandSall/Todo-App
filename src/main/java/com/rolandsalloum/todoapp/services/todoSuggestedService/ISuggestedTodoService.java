package com.rolandsalloum.todoapp.services.todoSuggestedService;

import com.rolandsalloum.todoapp.models.TodoSuggestion;

import java.util.List;
import java.util.UUID;

public interface ISuggestedTodoService {
    List<TodoSuggestion> getAllSuggestedTodos();

    TodoSuggestion getSuggestedTodoById(UUID suggestedTodoId) throws Exception;



    void deleteSuggestedTodoById(UUID suggestedTodoId) throws Exception;

    void updateSuggestedTodoById(UUID todoId, TodoSuggestion todoSuggestion);

    void createSuggestedTodo(TodoSuggestion todoSuggestion);
}
