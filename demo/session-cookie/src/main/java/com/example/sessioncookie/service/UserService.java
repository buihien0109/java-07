package com.example.sessioncookie.service;

import com.example.sessioncookie.dto.UserDto;
import com.example.sessioncookie.exception.NotFoundException;
import com.example.sessioncookie.mapper.UserMapper;
import com.example.sessioncookie.model.Role;
import com.example.sessioncookie.model.User;
import com.example.sessioncookie.request.LoginRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private List<User> users = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }

    public UserDto getUserById(int id) {
        Optional<User> optionalUser = findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return UserMapper.toUserDto(user);
        }

        throw new NotFoundException("user with id = " + id + " not exist");
    }

    public UserDto getUserByEmail(String email) {
        Optional<User> optionalUser = findByEmail(email);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return UserMapper.toUserDto(user);
        }

        throw new NotFoundException("user with email = " + email + " not exist");
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void addRoleToUser(int userId, Role role) {
        Optional<User> optionalUser = findById(userId);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            List<Role> roles = user.getRoles();
            roles.add(role);
            user.setRoles(roles);
        }
    }

    public Optional<User> findById(int id) {
        return users.stream().filter(user -> user.getId() == id).findFirst();
    }

    public Optional<User> findByEmail(String email) {
        return users.stream().filter(user -> user.getEmail().equals(email)).findFirst();
    }

    public void login(LoginRequest request) {
        Optional<User> userOptional = findByEmail(request.getEmail());
        if(userOptional.isEmpty()) {
            throw new NotFoundException("Email or password is incorrect");
        }

        User user = userOptional.get();
        if(!user.getPassword().equals(request.getPassword())) {
            throw new NotFoundException("Email or password is incorrect");
        }
    }
}
