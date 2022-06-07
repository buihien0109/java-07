package com.example.jpaonetomany.controller;

import com.example.jpaonetomany.repository.AuthorRepository;
import com.example.jpaonetomany.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@AllArgsConstructor
public class MyController {
    private final AuthorRepository authorRepository;
    private final PostRepository postRepository;

    @GetMapping("/posts")
    public ResponseEntity<?> getAllPost() {
        return ResponseEntity.ok(postRepository.findAll());
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<?> getPost(@PathVariable Long id) {
        return ResponseEntity.ok(postRepository.findById(id).get());
    }

    @GetMapping("/authors")
    public ResponseEntity<?> getAllAuthor() {
        return ResponseEntity.ok(authorRepository.findAll());
    }

    @GetMapping("/authors/{id}")
    public ResponseEntity<?> getAuthor(@PathVariable Long id) {
        return ResponseEntity.ok(authorRepository.findById(id).get());
    }
}
