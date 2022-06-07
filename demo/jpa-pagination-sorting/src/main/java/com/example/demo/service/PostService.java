package com.example.demo.service;

import com.example.demo.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostService {
    Post savePost(Post post);

    Page<Post> findAll(Pageable pageable);
}
