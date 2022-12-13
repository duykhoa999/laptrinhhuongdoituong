package com.group28.laptrinhhuongdoituong.service;

import java.util.List;

import com.group28.laptrinhhuongdoituong.dto.UserDTO;
import com.group28.laptrinhhuongdoituong.entity.UserEntity;

public interface IUserService {
  UserEntity save(UserDTO staffDTO);
  List<UserEntity> listStaff();
  List<UserEntity> listStaff(String keyWord);
  void delete(UserDTO productDTO);
  UserEntity findUserById(Long id);
  UserEntity update(UserDTO productDTO);
}
