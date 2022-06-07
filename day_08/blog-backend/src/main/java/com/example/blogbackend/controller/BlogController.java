package com.example.blogbackend.controller;

import com.example.blogbackend.model.Blog;
import com.example.blogbackend.model.response.BlogReturn;
import com.example.blogbackend.service.BlogService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@AllArgsConstructor
public class BlogController {
    private final BlogService blogService;

    @GetMapping(value = {"/", "/blogs"})
    public String getHomePage(Model model, @RequestParam(defaultValue = "1") int page) {
        BlogReturn blogReturn = blogService.getBlogs(page);
        model.addAttribute("blogReturn", blogReturn);

        return "anonymous/index";
    }

    @GetMapping("/blogs/{id}/{slug}")
    public String getBlogDetail(Model model, @PathVariable int id) {
        Optional<Blog> blogOptional = blogService.getBlogById(id);

        if (blogOptional.isEmpty()) {
            return "not-found";
        }

        model.addAttribute("blog", blogOptional.get());
        return "anonymous/detail";
    }
}
