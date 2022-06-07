package com.example.demo.controller;

import com.example.demo.request.AddAddressToUser;
import com.example.demo.request.CreateAddressReq;
import com.example.demo.request.CreateUserReq;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<?> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id) {
        return ResponseEntity.ok().body(userService.getUser(id));
    }

    @PostMapping("/users")
    public ResponseEntity<?> createUser(@RequestBody CreateUserReq req) {
        return ResponseEntity.ok().body(userService.createUser(req));
    }

    @GetMapping("/address")
    public ResponseEntity<?> getAllAddress() {
        return ResponseEntity.ok().body(userService.getAllAddress());
    }

    @GetMapping("/address/{id}")
    public ResponseEntity<?> getAddress(@PathVariable Long id) {
        return ResponseEntity.ok().body(userService.getAddress(id));
    }

    @PostMapping("/address")
    public ResponseEntity<?> createAddress(@RequestBody CreateAddressReq req) {
        return ResponseEntity.ok().body(userService.createAddress(req));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/users/add-address")
    public ResponseEntity<?> addAddressToUser(@RequestBody AddAddressToUser req) {
        userService.addAddressToUser(req.getName(), req.getCity());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
