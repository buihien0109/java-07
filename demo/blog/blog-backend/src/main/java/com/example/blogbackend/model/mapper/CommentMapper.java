package com.example.blogbackend.model.mapper;

import com.example.blogbackend.controller.admin.UserAdminController;
import com.example.blogbackend.model.dto.CommentDto;
import com.example.blogbackend.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;

public class CommentMapper {
    @Autowired
    private UserAdminController userAdminService;

    public static CommentDto toCommentDto(Comment comment) {
        // Tạo commentDto và set các thông tin cho đối tượng commentDto
        CommentDto commentDto = new CommentDto();

        commentDto.setId(comment.getId());
        commentDto.setContent(comment.getContent());
        commentDto.setAuthorId(commentDto.getAuthorId());
        commentDto.setCreatedAt(commentDto.getCreatedAt());

        return commentDto;
    }
}
