package com.rolandsalloum.todoapp.controllers.TodoController;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TodoApiUpdateRequest {
    private String title;
    private String description;
    private boolean isCompleted;
    private String  importance;
}
