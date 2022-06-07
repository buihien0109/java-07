package com.example.sessioncookie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AnonymousController {
    @GetMapping("/")
    public String getHomePage() {
        return "index";
    }
}
