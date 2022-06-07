package com.example.sessioncookie.session;

import com.example.sessioncookie.dto.UserDto;
import com.example.sessioncookie.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SessionStorage {
    private Map<String, UserDto> sessions = new HashMap<>();

    public void setSession(String token, UserDto data) {
        sessions.put(token, data);
    }

    public UserDto getDataWithToken(String token) {
        return sessions.get(token);
    }
}
