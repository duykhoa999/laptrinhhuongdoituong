package com.group28.laptrinhhuongdoituong.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group28.laptrinhhuongdoituong.converter.UserConverter;
import com.group28.laptrinhhuongdoituong.dto.Keyword;
import com.group28.laptrinhhuongdoituong.dto.UserDTO;
import com.group28.laptrinhhuongdoituong.entity.UserEntity;
import com.group28.laptrinhhuongdoituong.response.ResponseHandler;
import com.group28.laptrinhhuongdoituong.service.implement.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

  @Autowired
  private UserService userService;

  @Autowired
  private UserConverter userConverter;

  @Autowired
  PasswordEncoder encoder;

  @GetMapping
  public ResponseEntity<Object> listAllUser(@RequestBody Keyword keyword) {
    List<UserEntity> listUser = new ArrayList<>();
    if (StringUtils.isNotBlank(keyword.getKeyword())) {
      listUser = userService.listUser(keyword.getKeyword());
    } else {
      listUser = userService.listUser();
    }
    if (listUser.isEmpty()) {
      return ResponseHandler.generateResponse("list user is empty", HttpStatus.OK, new ArrayList<>());
    }
    return ResponseHandler.generateResponse("Get user successfully", HttpStatus.OK, listUser);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<?> findUser(@PathVariable("id") Long id) {
    UserEntity entity = userService.findUserById(id);
    if (entity == null) {
      return ResponseHandler.generateResponse("User not found", HttpStatus.OK, null);
    }
    return ResponseHandler.generateResponse("Get user successfully", HttpStatus.OK, entity);
  }

  @PostMapping
  public ResponseEntity<?> saveUser(@Valid @RequestBody UserDTO userDTO) {
    UserEntity userEntityByEmail = userService.findUserByEmail(userDTO.getEmail());
    if (userEntityByEmail != null) {
      return ResponseHandler.generateResponse("Email is already exists", HttpStatus.OK, null);
    }
    String password = encoder.encode(userDTO.getPassword());
    userDTO.setPassword(password);
    UserEntity userEntity = userService.save(userDTO);
    return ResponseHandler.generateResponse("add user successfully", HttpStatus.OK, userEntity);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
    UserEntity userEntity = userService.findUserById(id);
    if (userEntity == null) {
      return ResponseHandler.generateResponse("User not found", HttpStatus.OK, null);
    }
    userService.delete(userConverter.toDTO(userEntity));
    return ResponseHandler.generateResponse("Delete User successfully", HttpStatus.OK, userEntity);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<?> updateUser(@PathVariable("id") Long id, @Valid @RequestBody UserDTO userDTO) {
    userDTO.setId(id);
    UserEntity userEntity = userService.findUserById(id);
    if (userEntity == null) {
      return ResponseHandler.generateResponseErr(HttpStatus.OK, "cannot find user with id: " + id);
    }
    UserEntity user = userService.save(userDTO);
    return ResponseHandler.generateResponse("update user successfully", HttpStatus.OK, user);
  }
  
}
