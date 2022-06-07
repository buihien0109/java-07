package com.example.blogbackend.service;

import com.example.blogbackend.model.Blog;
import com.example.blogbackend.model.mapper.BlogMapper;
import com.example.blogbackend.model.response.BlogResponse;
import com.example.blogbackend.model.response.BlogReturn;
import com.example.blogbackend.service.admin.BlogAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService {
    private final int BLOG_OF_PAGE = 6;

    private final BlogMapper blogMapper;
    private final BlogAdminService blogAdminService;

    public BlogService(BlogMapper blogMapper, BlogAdminService blogAdminService) {
        this.blogMapper = blogMapper;
        this.blogAdminService = blogAdminService;
    }

    // Lấy danh sách blog được phân trang
    public BlogReturn getBlogs(int page) {

        // Danh sách bài viết
        List<Blog> blogs = blogAdminService.getBlogs();

        // Danh sách Blog được phân trang
        List<BlogResponse> blogsReturn = blogs.stream()
                .filter(Blog::isStatus)
                .sorted((a, b) -> b.getCreatedAt().compareTo(a.getCreatedAt()))
                .skip((long) (page - 1) * BLOG_OF_PAGE)
                .limit(BLOG_OF_PAGE)
                .map(blogMapper::toBlogResponse)
                .toList();

        // Danh sách bài viết đã active
        List<Blog> blogsActive = blogs.stream()
                .filter(Blog::isStatus)
                .toList();

        // Tính tổng số page
        int totalPage = (int) Math.ceil((double) blogsActive.size() / BLOG_OF_PAGE);

        return new BlogReturn(blogsReturn, totalPage);
    }

    public Optional<Blog> getBlogById(int id) {
        return blogAdminService
                .getBlogs()
                .stream()
                .filter(blog -> blog.getId() == id).findFirst();
    }
}


