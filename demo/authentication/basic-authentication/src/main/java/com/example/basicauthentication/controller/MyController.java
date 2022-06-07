package com.example.basicauthentication.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @GetMapping("/home")
    public ResponseEntity<?> getHome() {
        return ResponseEntity.ok("home");
    }

    @GetMapping("/profile")
    public ResponseEntity<?> getProfile() {
        return ResponseEntity.ok("profile");
    }

    @GetMapping("/hello")
    public ResponseEntity<?> getHello() {
        return ResponseEntity.ok("hello");
    }
}
