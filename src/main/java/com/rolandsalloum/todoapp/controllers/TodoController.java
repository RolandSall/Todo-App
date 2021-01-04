package com.rolandsalloum.todoapp.controllers;

import com.rolandsalloum.todoapp.services.todoService.ITodoService;
import com.rolandsalloum.todoapp.services.todoService.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }
}
