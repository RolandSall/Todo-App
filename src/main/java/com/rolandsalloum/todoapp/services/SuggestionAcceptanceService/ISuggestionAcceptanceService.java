package com.rolandsalloum.todoapp.services.SuggestionAcceptanceService;

import com.rolandsalloum.todoapp.models.Todo;

import java.util.UUID;

public interface ISuggestionAcceptanceService {
    Todo setPriorityForSuggestedTodo(UUID suggestedTodoId, String importance) throws Exception;
}
