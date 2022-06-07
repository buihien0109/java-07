package com.example.sessioncookie.session;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Optional;

@Component
@Slf4j
public class SessionDetailFilter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // Đọc cookie từ trong request
        Optional<String> optionalSessionToken = readCookie(request, "TECHMASTER");
        if(optionalSessionToken.isEmpty()) {
            // TODO : Xử lý view
        }

        // Lấy thông tin user


        // Lấy thông tin từ session token
        return true;
    }

    public Optional<String> readCookie(HttpServletRequest request, String name){
        return Arrays.stream(request.getCookies())
                .filter(cookie->name.equals(cookie.getName()))
                .map(Cookie::getValue)
                .findFirst();
    }
}
