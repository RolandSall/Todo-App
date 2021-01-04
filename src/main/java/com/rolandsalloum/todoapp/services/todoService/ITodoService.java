package com.rolandsalloum.todoapp.services.todoService;

import com.rolandsalloum.todoapp.models.Todo;

import java.util.List;
import java.util.UUID;

public interface ITodoService {

    List<Todo> getAllTodos();

    Todo createTodo(Todo buildTodoFromRequest);

    Todo getTodoById(UUID todoId) throws Exception;

    void deleteTodoById(UUID todoId) throws Exception;

    void updateTodoById(UUID todoId, Todo buildTodoFromRequest);
}
