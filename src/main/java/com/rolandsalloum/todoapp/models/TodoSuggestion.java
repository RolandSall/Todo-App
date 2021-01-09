package com.rolandsalloum.todoapp.models;


import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TodoSuggestion {
    private UUID todoId;
    private String email;
    private String fullName;
    private String title;
    private String description;
}
