package com.group28.laptrinhhuongdoituong.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group28.laptrinhhuongdoituong.dto.RoleDTO;
import com.group28.laptrinhhuongdoituong.entity.RoleEntity;
import com.group28.laptrinhhuongdoituong.repository.RoleRepository;
import com.group28.laptrinhhuongdoituong.service.IRoleService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class RoleService implements IRoleService {

  @Autowired
  private RoleRepository roleRepository;

  @Override
  public RoleEntity save(RoleDTO roleDTO) {
    return null;
  }

  @Override
  public List<RoleEntity> listRole() {
    return null;
  }

  @Override
  public void delete(RoleDTO productDTO) {
    
  }

  @Override
  public RoleEntity findRoleById(Long id) {
    if (roleRepository.findById(id).isEmpty()) {
      return null;
    }
    return roleRepository.findById(id).get();
  }

  @Override
  public RoleEntity update(RoleDTO productDTO) {
    return null;
  }

  @Override
  public List<RoleEntity> listRole(String keyWord) {
    return null;
  }
  
}
