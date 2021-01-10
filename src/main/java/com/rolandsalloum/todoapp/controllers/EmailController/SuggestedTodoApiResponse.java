package com.rolandsalloum.todoapp.controllers.EmailController;


import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class SuggestedTodoApiResponse {
    private UUID suggestedTodoId;
    private String email;
    private String fullName;
    private String title;
    private String description;
}
