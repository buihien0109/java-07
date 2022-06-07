package com.example.demo.bmi;

import com.example.demo.model.request.CalculateBmiRequest;
import com.example.demo.model.response.ResponseObject;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class BmiController {
    private BmiService bmiService;

    @GetMapping("/bmi")
    public ResponseEntity<ResponseObject> calculateBmiWithGet(
            @RequestParam double weight,
            @RequestParam double height
    ) {
        double bmi = bmiService.calculateBmi(weight, height);
        return ResponseEntity.ok().body(
                new ResponseObject("ok", "calculate bmi successfullly", bmi)
        );
    }

    @PostMapping("/bmi")
    public ResponseEntity<ResponseObject> calculateBmiWithPost(
            @RequestBody CalculateBmiRequest request
    ) {
        double bmi = bmiService.calculateBmi(request.getWeight(), request.getHeight());
        return ResponseEntity.ok().body(
                new ResponseObject("ok", "calculate bmi successfullly", bmi)
        );
    }
}
