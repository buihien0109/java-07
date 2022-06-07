package com.example.demo;

import com.example.demo.entity.Post;
import com.example.demo.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Random;
import java.util.stream.IntStream;

@SpringBootApplication
public class JpaPaginationSortingApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaPaginationSortingApplication.class, args);
    }

    @Bean
    CommandLineRunner run(PostService postService) {
        Random rd = new Random();
        return args -> {
            IntStream.range(1, 50).forEach(n -> {
                Post post = new Post();
                post.setTitle("Tiêu đề " + n);
                post.setDescription("Mô tả " + n);
                post.setLikePost(rd.nextInt(100 -50 + 1) + 50);
                postService.savePost(post);
            });
        };
    }
}
