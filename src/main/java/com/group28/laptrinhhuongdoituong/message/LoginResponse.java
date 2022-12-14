package com.group28.laptrinhhuongdoituong.message;

import com.group28.laptrinhhuongdoituong.entity.UserEntity;

import lombok.Data;

@Data
public class LoginResponse {
    private UserEntity user;
    private String accessToken;

    public LoginResponse(UserEntity user, String accessToken) {
        this.user = user;
        this.accessToken = accessToken;
    }
}
