package com.group28.laptrinhhuongdoituong.service.implement;

import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group28.laptrinhhuongdoituong.dto.RoleDTO;
import com.group28.laptrinhhuongdoituong.entity.RoleEntity;
import com.group28.laptrinhhuongdoituong.service.IRoleService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class RoleService implements IRoleService {

  @Override
  public RoleEntity save(RoleDTO roleDTO) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<RoleEntity> listRole() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void delete(RoleDTO productDTO) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public RoleEntity findRoleById(Long id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public RoleEntity update(RoleDTO productDTO) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<RoleEntity> listRole(String keyWord) {
    // TODO Auto-generated method stub
    return null;
  }
  
}
