package com.rolandsalloum.todoapp.services.todoService;

import com.rolandsalloum.todoapp.models.Todo;
import com.rolandsalloum.todoapp.repos.ITodoRepositoryDAO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    @Override
    public Todo getTodoById(UUID todoId) throws Exception {
        Optional<Todo> todo = iTodoRepositoryDAO.findById(todoId);
        if (todo.isPresent()) {
            return todo.get();
        }else {
            throw new Exception("Todo Not Found");
        }
    }

    @Override
    public void deleteTodoById(UUID todoId) throws Exception {
        Optional<Todo> todoToBeDeleted = iTodoRepositoryDAO.findById(todoId);
        if (todoToBeDeleted.isPresent()) {
            iTodoRepositoryDAO.delete(todoToBeDeleted.get());
        }else {
            throw new Exception("Todo Not Found");
        }
    }

    @Override
    public void updateTodoById(UUID todoId, Todo todo) {
        todo.setTodoId(todoId);
        iTodoRepositoryDAO.save(todo);
    }
}
