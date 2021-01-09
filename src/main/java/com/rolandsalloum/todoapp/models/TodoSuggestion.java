package com.rolandsalloum.todoapp.models;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class TodoSuggestion {
    @Id
    private UUID todoId;
    private String email;
    private String fullName;
    private String title;
    private String description;
}
