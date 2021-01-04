package com.rolandsalloum.todoapp.repos;

import com.rolandsalloum.todoapp.models.Todo;

import java.util.List;

public interface ITodoRepositoryDAO {
    List<Todo> getAllTodos();
}
