package com.rolandsalloum.todoapp.services.todoService;

import com.rolandsalloum.todoapp.models.Todo;
import com.rolandsalloum.todoapp.repos.ITodoRepositoryDAO;
import com.rolandsalloum.todoapp.repos.TodoRepositoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService implements ITodoService {

    private TodoRepositoryDAO todoRepositoryDAO;

    @Autowired
    public TodoService(TodoRepositoryDAO todoRepositoryDAO) {
        this.todoRepositoryDAO = todoRepositoryDAO;
    }

    @Override
    public List<Todo> getAllTodos() {
        return todoRepositoryDAO.getAllTodos();
    }
}
