package com.example.blogbackend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private int id;
    private int authorId;
    private int postId;
    private String content;
//    private boolean accept;
    private LocalDateTime createdAt;
}
