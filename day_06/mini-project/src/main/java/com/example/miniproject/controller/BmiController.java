package com.example.miniproject.controller;

import com.example.miniproject.request.BmiRequest;
import com.example.miniproject.service.BmiService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class BmiController {

    private final BmiService bmiService;

    @GetMapping("/bmi")
    public ResponseEntity<?> calculateBmiGet(@RequestParam double height,
                                             @RequestParam double weight) {

        double bmi = bmiService.calculateBmi(height, weight);
        return ResponseEntity.ok(bmi);
    }

    @PostMapping("/bmi")
    public ResponseEntity<?> calculateBmiPost(@RequestBody BmiRequest request) {
        double bmi = bmiService.calculateBmi(request.getHeight(), request.getWeight());
        return ResponseEntity.ok(bmi);
    }
}
