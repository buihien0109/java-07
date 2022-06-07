package com.example.jpaonetomany;

import com.example.jpaonetomany.entity.Author;
import com.example.jpaonetomany.entity.Post;
import com.example.jpaonetomany.repository.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.Random;

@SpringBootApplication
public class JpaOneToManyApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaOneToManyApplication.class, args);
    }

    @Bean
    CommandLineRunner run(PostRepository postRepository) {
        return args -> {
            Author author = Author.builder().name("Nguyễn Văn A").build();
            Author author1 = Author.builder().name("Bùi Hiên").build();
            Author author2 = Author.builder().name("Nguyễn Thu Hằng").build();

            Post post = Post.builder().title("Post 1").publishAt(2020).author(author).build();
            Post post1 = Post.builder().title("Post 2").publishAt(2020).author(author).build();
            Post post2 = Post.builder().title("Post 3").publishAt(2021).author(author1).build();
            Post post3 = Post.builder().title("Post 4").publishAt(2022).author(author1).build();
            Post post4 = Post.builder().title("Post 5").publishAt(2020).author(author2).build();
            Post post5 = Post.builder().title("Post 6").publishAt(2021).author(author2).build();
            Post post6 = Post.builder().title("Post 7").publishAt(2021).author(author2).build();

            postRepository.saveAll(Arrays.asList(post, post1, post2, post3, post4, post5, post6));
        };
    }

}
