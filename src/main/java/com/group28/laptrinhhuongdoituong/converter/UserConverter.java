package com.group28.laptrinhhuongdoituong.converter;

import com.group28.laptrinhhuongdoituong.dto.UserDTO;
import com.group28.laptrinhhuongdoituong.entity.UserEntity;
import com.group28.laptrinhhuongdoituong.service.implement.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    @Autowired
    private RoleService roleService;

    public UserDTO toDTO(UserEntity userEntity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userEntity.getId());
        userDTO.setFirst_name(userEntity.getFirst_name());
        userDTO.setLast_name(userEntity.getLast_name());
        userDTO.setGender(userEntity.getGender());
        userDTO.setDob(userEntity.getDob());
        userDTO.setAddress(userEntity.getAddress());
        userDTO.setPhone(userEntity.getPhone());
        userDTO.setEmail(userEntity.getEmail());
        userDTO.setPassword(userEntity.getPassword());
        userDTO.setRole_id(userEntity.getRole().getId());
        userDTO.setDeleted(userEntity.getDeleted());

        return userDTO;
    }

    public UserEntity toEntity(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userDTO.getId());
        userEntity.setFirst_name(userDTO.getFirst_name());
        userEntity.setLast_name(userDTO.getLast_name());
        userEntity.setGender(userDTO.getGender());
        userEntity.setDob(userDTO.getDob());
        userEntity.setAddress(userDTO.getAddress());
        userEntity.setPhone(userDTO.getPhone());
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setRole(roleService.findRoleById(userDTO.getRole_id()));
        userEntity.setDeleted(userDTO.getDeleted());

        return userEntity;
    }
}
