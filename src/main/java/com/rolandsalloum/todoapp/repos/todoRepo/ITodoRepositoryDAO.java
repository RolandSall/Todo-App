package com.rolandsalloum.todoapp.repos.todoRepo;

import com.rolandsalloum.todoapp.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ITodoRepositoryDAO extends JpaRepository<Todo, UUID> {

}
