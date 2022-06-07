package com.example.blogbackend.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class VerifyService {
    private Map<String, TokenInfo> tokens = new HashMap<>();

    public Map<String, TokenInfo> getTokens() {
        return tokens;
    }

    public void saveToken(int userId, String token) {
        TokenInfo tokenInfo = new TokenInfo(userId, LocalDateTime.now().plusMinutes(15));
        tokens.put(token, tokenInfo);
    }

    public boolean checkToken(int userId, String token) {
        // Lấy giá trị tương ứng với token
        TokenInfo tokenInfo = tokens.get(token);

        // Kiểm tra giá trị có giống userId đang kích hoạt hay không
        if(tokenInfo.getUserId() != userId) {
            throw new RuntimeException("Lỗi khi kiểm tra token");
        }

        // Kiểm tra token còn thời gian hiệu lực hay không?
        if(tokenInfo.getExpiredTime().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Token đã hết hạn");
        }

        return true;
    }
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class TokenInfo {
    private int UserId;
    private LocalDateTime ExpiredTime;
}


