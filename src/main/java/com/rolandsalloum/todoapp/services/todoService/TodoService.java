package com.rolandsalloum.todoapp.services.todoService;

import com.rolandsalloum.todoapp.models.Todo;
import com.rolandsalloum.todoapp.repos.ITodoRepositoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TodoService implements ITodoService {

    private ITodoRepositoryDAO iTodoRepositoryDAO;

    public TodoService(ITodoRepositoryDAO iTodoRepositoryDAO) {
        this.iTodoRepositoryDAO = iTodoRepositoryDAO;
    }

    @Override
    public List<Todo> getAllTodos() {
        return iTodoRepositoryDAO.findAll();
    }

    @Override
    public Todo createTodo(Todo todo) {
        UUID todoId = UUID.randomUUID();
        todo.setTodoId(todoId);
        return iTodoRepositoryDAO.save(todo);
    }
}
