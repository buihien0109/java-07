package com.example.demo;

import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class JwtDemoVideoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtDemoVideoApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null, "bob name", "bob", "111", new ArrayList<>()));
            userService.saveUser(new User(null, "john name", "john", "111", new ArrayList<>()));
            userService.saveUser(new User(null, "alice name", "alice", "111", new ArrayList<>()));
            userService.saveUser(new User(null, "anna name", "anna", "111", new ArrayList<>()));

            userService.addRoleToUser("bob", "ROLE_USER");
            userService.addRoleToUser("bob", "ROLE_MANAGER");
            userService.addRoleToUser("john", "ROLE_MANAGER");
            userService.addRoleToUser("alice", "ROLE_ADMIN");
            userService.addRoleToUser("anna", "ROLE_SUPER_ADMIN");
            userService.addRoleToUser("anna", "ROLE_ADMIN");
            userService.addRoleToUser("anna", "ROLE_USER");
        };
    }

}
