package com.example.blogbackend.controller.admin;

import com.example.blogbackend.model.Blog;
import com.example.blogbackend.model.response.BlogReturn;
import com.example.blogbackend.service.admin.BlogAdminService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
@AllArgsConstructor
public class BlogViewController {

    private final BlogAdminService blogAdminService;

    @GetMapping("/blogs")
    public String getIndexBlogPage(Model model, @RequestParam(defaultValue = "1") int page) {
        BlogReturn blogReturn = blogAdminService.getBlogs(page);

        model.addAttribute("blogReturn", blogReturn);
        return "admin/blog/index";
    }

    @GetMapping("/blogs/create")
    public String getCreateBlogPage() {
        return "admin/blog/create";
    }

    @GetMapping("/blogs/{id}")
    public String getUpdateBlogPage(Model model, @PathVariable int id) {
        Blog blog = blogAdminService.getBlogById(1, id);
        model.addAttribute("blog", blog);

        return "admin/blog/update";
    }
}
