package com.example.blogbackend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @PostMapping("/api/signin")
    public ResponseEntity<?> signin() {
        return null;
    }

    @PostMapping("/api/signup")
    public ResponseEntity<?> signup() {
        return null;
    }

    @PostMapping("/api/logout")
    public ResponseEntity<?> logout() {
        return null;
    }
}
