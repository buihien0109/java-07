package com.example.sessioncookie.dto;

import com.example.sessioncookie.model.Role;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDto {
    private int id;
    private String name;
    private String email;
    private List<Role> roles;
}
