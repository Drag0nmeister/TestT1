package org.example.TaskT1.controller;

import org.example.TaskT1.exception.ApiError;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.example.TaskT1.service.FrequencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/frequency")
public class FrequencyController {

    private final FrequencyService frequencyService;

    @Autowired
    public FrequencyController(FrequencyService frequencyService) {
        this.frequencyService = frequencyService;
    }

    @GetMapping
    public ResponseEntity<?> computeFrequency(@Valid @RequestParam @NotBlank(message = "Text cannot be blank.") @Size(max = 1000, message = "Text length cannot exceed 1000 characters.") @Pattern(regexp = "[A-Za-z0-9]+", message = "Text can only contain alphanumeric characters.") String text) {
        return ResponseEntity.ok(frequencyService.computeFrequency(text));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleValidationExceptions(MethodArgumentNotValidException ex) {
        String errorMsg = ex.getBindingResult()
                .getAllErrors().stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.joining(", "));
        return ResponseEntity.badRequest().body(new ApiError(errorMsg));
    }

}
