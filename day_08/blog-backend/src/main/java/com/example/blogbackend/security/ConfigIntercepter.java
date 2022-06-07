package com.example.blogbackend.security;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConfigIntercepter implements HandlerInterceptor {
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView
    ) throws Exception {
        // Lấy thông tin user từ session

        // Nếu có user đăng nhập -> trả về thông tin của user thông qua view

        // Xem chi tiết tại đây : https://github.com/buihien0109/docker/blob/master/obo1/src/main/java/com/company/demo/security/ConfigInterceptor.java
    }
}
