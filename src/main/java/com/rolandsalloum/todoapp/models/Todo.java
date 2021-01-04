package com.rolandsalloum.todoapp.models;

import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Todo {
    private UUID todoId;
    private String title;
    private String description;
}
