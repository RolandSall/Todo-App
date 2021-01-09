package com.rolandsalloum.todoapp.controllers.TodoController;

import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TodoApiRequest {
    private String title;
    private String description;
    private String  importance;
}
