package com.rolandsalloum.todoapp.repos.suggestedTodoRepo;

import com.rolandsalloum.todoapp.models.TodoSuggestion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ISuggestedTodoRepositoryDAO extends JpaRepository<TodoSuggestion, UUID> {
}
