package com.group28.laptrinhhuongdoituong.service;

import java.util.List;

import com.group28.laptrinhhuongdoituong.dto.RoleDTO;
import com.group28.laptrinhhuongdoituong.entity.RoleEntity;

public interface IRoleService {
  RoleEntity save(RoleDTO roleDTO);
  List<RoleEntity> listRole();
  List<RoleEntity> listRole(String keyWord);
  void delete(RoleDTO productDTO);
  RoleEntity findRoleById(Long id);
  RoleEntity update(RoleDTO productDTO);
}
