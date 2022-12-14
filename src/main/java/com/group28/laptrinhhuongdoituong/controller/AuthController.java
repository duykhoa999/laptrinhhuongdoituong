package com.group28.laptrinhhuongdoituong.controller;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group28.laptrinhhuongdoituong.entity.UserEntity;
import com.group28.laptrinhhuongdoituong.message.LoginRequest;
import com.group28.laptrinhhuongdoituong.message.LoginResponse;
import com.group28.laptrinhhuongdoituong.repository.RoleRepository;
import com.group28.laptrinhhuongdoituong.repository.UserRepository;
import com.group28.laptrinhhuongdoituong.response.ResponseHandler;
import com.group28.laptrinhhuongdoituong.security.jwt.JwtTokenProvider;
import com.group28.laptrinhhuongdoituong.security.services.CustomUserDetails;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UserRepository userRepository;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  private JwtTokenProvider tokenProvider;

  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
    // Xác thực thông tin người dùng Request lên
    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            loginRequest.getEmail(),
            loginRequest.getPassword()));

    // Nếu không xảy ra exception tức là thông tin hợp lệ
    // Set thông tin authentication vào Security Context
    SecurityContextHolder.getContext().setAuthentication(authentication);
    UserEntity user = userRepository.findByEmail(loginRequest.getEmail());
    // Trả về jwt cho người dùng.
    String jwt = tokenProvider.generateToken((CustomUserDetails) authentication.getPrincipal());
    LoginResponse loginResponse = new LoginResponse(user, jwt);
    return ResponseHandler.generateResponse("Login", HttpStatus.OK, loginResponse);
  }

}
