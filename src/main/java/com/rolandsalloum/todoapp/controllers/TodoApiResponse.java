package com.rolandsalloum.todoapp.controllers;


import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TodoApiResponse {
    private UUID todoId;
    private String title;
    private String description;
    private boolean isCompleted;
    private String  importance;
}
