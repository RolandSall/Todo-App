package com.rolandsalloum.todoapp.controllers;

import com.rolandsalloum.todoapp.models.Todo;
import com.rolandsalloum.todoapp.services.todoService.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }
    
    @GetMapping
    public ResponseEntity getAllTodos(){
        try {
            List<Todo> todoList = todoService.getAllTodos();
            List<TodoApiResponse> todoListResponse= buildListOfResponseFrom(todoList);
            return ResponseEntity.status(HttpStatus.OK).body(todoListResponse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity createTodo(TodoApiRequest request){
        try {
            Todo todo = todoService.createTodo(buildTodoFromRequest(request));
            TodoApiResponse response = buildSingleTodoResponse(todo);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    private Todo buildTodoFromRequest(TodoApiRequest request) {
        return new Todo().builder()
                .title(request.getTitle())
                .description(request.getTitle())
                .build();
    }

    private List<TodoApiResponse> buildListOfResponseFrom(List<Todo> todoList) {
        List<TodoApiResponse> responseList = new ArrayList<>();
        for (Todo todo : todoList) {
            responseList.add(buildSingleTodoResponse(todo));
        }
        return responseList;

    }

    private TodoApiResponse buildSingleTodoResponse(Todo todo) {
        return new TodoApiResponse().builder()
                .todoId(todo.getTodoId())
                .title(todo.getTitle())
                .description(todo.getDescription())
                .build();
    }
}
