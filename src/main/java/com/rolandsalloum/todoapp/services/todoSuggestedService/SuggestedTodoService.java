package com.rolandsalloum.todoapp.services.todoSuggestedService;
import com.rolandsalloum.todoapp.models.TodoSuggestion;
import com.rolandsalloum.todoapp.repos.suggestedTodoRepo.ISuggestedTodoRepositoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SuggestedTodoService implements ISuggestedTodoService {

    private ISuggestedTodoRepositoryDAO iSuggestedTodoRepositoryDAO;

    @Autowired
    public SuggestedTodoService(ISuggestedTodoRepositoryDAO iSuggestedTodoRepositoryDAO) {
        this.iSuggestedTodoRepositoryDAO = iSuggestedTodoRepositoryDAO;
    }

    @Override
    public List<TodoSuggestion> getAllSuggestedTodos() {
        return iSuggestedTodoRepositoryDAO.findAll();
    }

    @Override
    public TodoSuggestion getSuggestedTodoById(UUID suggestedTodoId) throws Exception {
        Optional<TodoSuggestion> todoSuggestion = iSuggestedTodoRepositoryDAO.findById(suggestedTodoId);
        if (todoSuggestion.isPresent()) {
            return todoSuggestion.get();
        }else {
            throw new Exception("Suggested Todo Not Found");
        }
    }

    @Override
    public void deleteSuggestedTodoById(UUID suggestedTodoId) throws Exception {
        Optional<TodoSuggestion> todoSuggestion = iSuggestedTodoRepositoryDAO.findById(suggestedTodoId);
        if (todoSuggestion.isPresent()) {
           iSuggestedTodoRepositoryDAO.delete(todoSuggestion.get());
        }else {
            throw new Exception("Suggested Todo Not Found");
        }
    }

    @Override
    public void updateSuggestedTodoById(UUID todoId, TodoSuggestion todoSuggestion) {
        todoSuggestion.setSuggestedTodoId(todoId);
        iSuggestedTodoRepositoryDAO.save(todoSuggestion);
    }

    @Override
    public void createSuggestedTodo(TodoSuggestion todoSuggestion) {
        iSuggestedTodoRepositoryDAO.save(todoSuggestion);
    }
}
