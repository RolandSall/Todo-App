package com.rolandsalloum.todoapp.controllers.EmailController;

import lombok.*;

import javax.persistence.Entity;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TodoSuggestionRequest {
    private String email;
    private String fullName;
    private String title;
    private String description;
}
