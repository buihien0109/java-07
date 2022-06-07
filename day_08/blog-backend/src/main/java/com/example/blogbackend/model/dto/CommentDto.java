package com.example.blogbackend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {
    private int id;
    private int authorId;
    private int authorName;
    private int authorAvatar;
    private String content;
    private LocalDateTime createdAt;
}
