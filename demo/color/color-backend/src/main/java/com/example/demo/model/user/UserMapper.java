package com.example.demo.model.user;

public class UserMapper {
    public static UserDto toUserDto(User u) {
        UserDto userDto = new UserDto();
        userDto.setUsername(u.getUsername());
        userDto.setEmail(u.getEmail());
        userDto.setAvatar(u.getAvatar());
        return userDto;
    }
}
