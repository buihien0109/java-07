package com.example.sessioncookie;

import com.example.sessioncookie.model.User;
import com.example.sessioncookie.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SessionCookieApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void test_getUser() {
        List<User> users = userService.getUsers();
        users.forEach(user -> {
            System.out.println(user);
            user.getRoles().forEach(role -> {
                System.out.println(role);
            });
        });
    }

}
