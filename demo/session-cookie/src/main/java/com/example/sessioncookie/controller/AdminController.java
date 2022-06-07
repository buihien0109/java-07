package com.example.sessioncookie.controller;

import com.example.sessioncookie.dto.UserDto;
import com.example.sessioncookie.request.LoginRequest;
import com.example.sessioncookie.service.UserService;
import com.example.sessioncookie.session.SessionStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;


@Controller
public class AdminController {
    @Autowired
    private UserService userService;

    @Autowired
    private SessionStorage sessionStorage;

    @GetMapping("/admin")
    public String getAdminPage() {
        return "admin";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<?> login(@RequestBody LoginRequest req, HttpServletRequest request) {
        // Kiểm tra xem request có hợp lệ hay không
        userService.login(req);

        // Tao session
        HttpSession session = request.getSession();
        UserDto userDto = userService.getUserByEmail(req.getEmail());

        String sessionToken = UUID.randomUUID().toString();
        session.setAttribute(sessionToken, userDto);

        // Luu lai session
        sessionStorage.setSession(sessionToken, userDto);

        // Tạo cookie
        ResponseCookie cookie = ResponseCookie.from("TECHMASTER", sessionToken)
                .httpOnly(true)
                .secure(true)
                .maxAge(3600)
                .build();

        return  ResponseEntity
                .ok()
                .header(HttpHeaders.SET_COOKIE, cookie.toString())
                .build();
    }
}
