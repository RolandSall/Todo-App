package com.rolandsalloum.todoapp.controllers;

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
}
