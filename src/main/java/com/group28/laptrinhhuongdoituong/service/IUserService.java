package com.group28.laptrinhhuongdoituong.service;

import java.util.List;

import com.group28.laptrinhhuongdoituong.dto.UserDTO;
import com.group28.laptrinhhuongdoituong.entity.UserEntity;

public interface IUserService {
  UserEntity save(UserDTO userDTO);
  List<UserEntity> listUser();
  List<UserEntity> listUser(String keyWord);
  void delete(UserDTO userDTO);
  UserEntity findUserById(Long id);
  UserEntity update(UserDTO userDTO);
}
