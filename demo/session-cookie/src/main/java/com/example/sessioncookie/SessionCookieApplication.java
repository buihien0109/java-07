package com.example.sessioncookie;

import com.example.sessioncookie.model.Role;
import com.example.sessioncookie.model.User;
import com.example.sessioncookie.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class SessionCookieApplication {

    public static void main(String[] args) {
        SpringApplication.run(SessionCookieApplication.class, args);
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            User user1 = new User(1, "Bùi Hiên", "hien@gmail.com", "111", new ArrayList<>());
            User user2 = new User(2, "Thu Hằng", "hang@gmail.com", "222", new ArrayList<>());

            Role roleAdmin = new Role(1, "ADMIN");
            Role roleUser = new Role(2, "USER");

            userService.addUser(user1);
            userService.addUser(user2);

            userService.addRoleToUser(1, roleAdmin);
            userService.addRoleToUser(1, roleUser);
            userService.addRoleToUser(2, roleUser);
        };
    }
}
