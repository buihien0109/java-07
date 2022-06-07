package com.example.blogbackend.security;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class RequestFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain
    ) throws ServletException, IOException {
        // Tham khảo : https://github.com/buihien0109/docker/blob/master/obo1/src/main/java/com/company/demo/security/JwtRequestFilter.java
        // Lấy thông tin cookie

        // Lấy thông tin session từ cookie

        // Kiểm tra session
    }
}
