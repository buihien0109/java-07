package com.example.demo.user;

import com.example.demo.model.request.LoginRequest;
import com.example.demo.model.response.ResponseObject;
import com.example.demo.model.user.UserDto;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

//    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<ResponseObject> login(@RequestBody LoginRequest request) {
        UserDto userDto = userService.login(request);
        return ResponseEntity.ok().body(
                new ResponseObject("ok", "login success", userDto)
        );
    }
}
