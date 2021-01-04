package com.rolandsalloum.todoapp.services.todoService;

import com.rolandsalloum.todoapp.models.Todo;

import java.util.List;

public interface ITodoService {

    List<Todo> getAllTodos();

    Todo createTodo(Todo buildTodoFromRequest);
}
