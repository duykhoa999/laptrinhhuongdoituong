package com.group28.laptrinhhuongdoituong.service.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group28.laptrinhhuongdoituong.converter.UserConverter;
import com.group28.laptrinhhuongdoituong.dto.UserDTO;
import com.group28.laptrinhhuongdoituong.entity.UserEntity;
import com.group28.laptrinhhuongdoituong.repository.UserRepository;
import com.group28.laptrinhhuongdoituong.service.IUserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService implements IUserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private UserConverter userConverter;

  @Override
  public UserEntity save(UserDTO userDTO) {
    return userRepository.save(userConverter.toEntity(userDTO));
  }

  @Override
  public List<UserEntity> listUser() {
    List<UserEntity> list = userRepository.findAll();
    return list.stream().filter(item -> BooleanUtils.isFalse(item.getDeleted())).collect(Collectors.toList());
  }

  @Override
  public void delete(UserDTO userDTO) {
    userRepository.delete(userConverter.toEntity(userDTO));
  }

  @Override
  public UserEntity findUserById(Long id) {
    if (userRepository.findById(id).isEmpty()) {
      return null;
    }
    return userRepository.findById(id).get();
  }

  @Override
  public UserEntity update(UserDTO userDTO) {
    return userRepository.save(userConverter.toEntity(userDTO));
  }

  @Override
  public List<UserEntity> listUser(String keyWord) {
    List<UserEntity> list = userRepository.search(keyWord);
    return list.stream().filter(item -> BooleanUtils.isFalse(item.getDeleted())).collect(Collectors.toList());
  }

  @Override
  public UserEntity findUserByEmail(String email) {
    if (userRepository.findByEmail(email) == null) {
      return null;
    }
    return userRepository.findByEmail(email);
  }

  @Override
  public UserDetails loadUserById(Long id) {
    return null;
  }
  
}
