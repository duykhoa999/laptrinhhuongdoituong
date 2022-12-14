package com.group28.laptrinhhuongdoituong.message;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class LoginRequest {
    @NotBlank
    private String email;

    @NotBlank
    private String password;
}
