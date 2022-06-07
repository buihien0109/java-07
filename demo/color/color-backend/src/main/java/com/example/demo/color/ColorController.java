package com.example.demo.color;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.response.ResponseObject;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ColorController {
    private ColorService colorService;

    @GetMapping("/random-color")
    @ResponseBody
    public ResponseEntity<?> randomColor(@RequestParam int type) {
        String color = switch (type) {
            case 1 -> colorService.randomColorName();
            case 2 -> colorService.randomHexColor();
            case 3 -> colorService.randomRbgColor();
            default -> throw new BadRequestException("Request không hợp lệ");
        };

        return ResponseEntity.ok().body(
                new ResponseObject("ok", "color generate successfully", color)
        );
    }
}
