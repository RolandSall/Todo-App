package com.rolandsalloum.todoapp.services.todoService;

import com.rolandsalloum.todoapp.repos.ITodoRepositoryDAO;
import com.rolandsalloum.todoapp.repos.TodoRepositoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService implements ITodoService {

    private TodoRepositoryDAO todoRepositoryDAO;

    @Autowired
    public TodoService(TodoRepositoryDAO todoRepositoryDAO) {
        this.todoRepositoryDAO = todoRepositoryDAO;
    }
}
