package com.rolandsalloum.todoapp.repos;

import com.rolandsalloum.todoapp.models.Todo;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Repository
public class TodoRepositoryDAO implements ITodoRepositoryDAO {

    @Override
    public List<Todo> getAllTodos() {
        return Arrays.asList(
                new Todo().builder().todoId(UUID.randomUUID()).description("Desc1").title("title1").build(),
                new Todo().builder().todoId(UUID.randomUUID()).description("Desc2").title("title2").build(),
                new Todo().builder().todoId(UUID.randomUUID()).description("Desc3").title("title3").build()
        );
    }
}
