package com.group28.laptrinhhuongdoituong.service.implement;

import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group28.laptrinhhuongdoituong.dto.UserDTO;
import com.group28.laptrinhhuongdoituong.entity.UserEntity;
import com.group28.laptrinhhuongdoituong.service.IUserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService implements IUserService {

  @Override
  public UserEntity save(UserDTO staffDTO) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<UserEntity> listStaff() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void delete(UserDTO productDTO) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public UserEntity findUserById(Long id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public UserEntity update(UserDTO productDTO) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<UserEntity> listStaff(String keyWord) {
    // TODO Auto-generated method stub
    return null;
  }
  
}
