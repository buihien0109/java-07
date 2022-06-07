package com.example.demo.controller;

import com.example.demo.entity.Post;
import com.example.demo.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/posts")
    public ResponseEntity<?> getPosts(@RequestParam int page, @RequestParam int limit) {
        Pageable paging = PageRequest.of(page, limit);
        Page<Post> posts = postService.findAll(paging);
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/posts/sort-by-like")
    public ResponseEntity<?> getPostByLike(@RequestParam int page, @RequestParam int limit) {
//        Pageable paging = PageRequest.of(page, limit, Sort.by("likePost").descending());
        Pageable paging = PageRequest.of(page, limit, Sort.Direction.DESC, "likePost");
        Page<Post> posts = postService.findAll(paging);
        return ResponseEntity.ok(posts);
    }
}
