package com.rolandsalloum.todoapp.controllers.EmailController;

import com.sun.istack.NotNull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class SuggestedTodoUpdateRequest {
    @NotNull
    private String email;
    @NotNull
    private String fullName;
    @NotNull
    private String title;
    @NotNull
    private String description;
}
