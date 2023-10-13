package org.example.TaskT1.exception;

import lombok.Getter;

@Getter
public class ApiError {
    private final String error;

    public ApiError(String errorMessage) {
        this.error = errorMessage;
    }

}
