package com.example.resfulapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class ErrorMessage {
    private int StatusCode ;
    private String message ;
}
