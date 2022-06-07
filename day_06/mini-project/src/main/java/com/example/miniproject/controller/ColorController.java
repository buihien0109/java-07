package com.example.miniproject.controller;

import com.example.miniproject.service.ColorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ColorController {

    private final ColorService colorService;

    @GetMapping("/random-color")
    public ResponseEntity<?> randomColor(@RequestParam int type) {
        String color = colorService.randomColor(type);
        return ResponseEntity.ok(color);
    }
}
