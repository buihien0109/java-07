package com.example.blogbackend.service;

import com.example.blogbackend.model.Role;
import com.example.blogbackend.model.User;
import com.example.blogbackend.model.mapper.UserMapper;
import com.example.blogbackend.model.request.CreateUserRequest;
import com.example.blogbackend.service.admin.UserAdminService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class UserService {
    private final UserAdminService userAdminService;
    private final Random rd;
    private final EmailService emailService;
    private final VerifyService verifyService;

    public void CreateUser(CreateUserRequest request) {
        // Kiểm tra đã tồn tại user với email định tạo hay chưa
        if (userAdminService.findUser(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email = " + request.getEmail() + " is existed!");
        }

        // Tạo user mới và chèn thông tin cho user
        User user = new User();
        user.setId(rd.nextInt(100));
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        user.setRoles(List.of(new Role(2, "USER")));

        // Thêm user vừa tạo vào trong List để quản lý
        userAdminService.getUsers().add(user);

        // Lưu token
        String generateToken = UUID.randomUUID().toString();
        verifyService.saveToken(user.getId(), generateToken);

        // Gửi mail kích hoạt
        emailService.sendMail(
                user.getEmail(),
                "Kích hoạt tài khoản",
                "Link kích hoạt: " + "http://localhost:8080/api/v1/users/" + user.getId() + "/tokens/" + generateToken
        );
    }

    // Kiểm tra token để kích hoạt trạng thái của user
    public void verifyToken(int userId, String token) {
        // Kiểm tra user có tồn tại hay không
        Optional<User> userOptional = userAdminService.findUser(userId);
        if (userOptional.isEmpty()) {
            throw new RuntimeException("Không tìm thấy user có id = " + userId);
        }

        // Lấy ra thông tin của user
        User user = userOptional.get();

        // Kiểm tra token + cập nhật lại status active cho user;
        if (verifyService.checkToken(userId, token)) {
            userOptional.get().setStatus(true);
        }
    }
}
