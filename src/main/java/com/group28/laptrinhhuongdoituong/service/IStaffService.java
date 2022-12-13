package com.group28.laptrinhhuongdoituong.service;

import java.util.List;

import com.group28.laptrinhhuongdoituong.dto.StaffDTO;
import com.group28.laptrinhhuongdoituong.entity.StaffEntity;

public interface IStaffService {
  StaffEntity save(StaffDTO staffDTO);

  List<StaffEntity> listStaff();

  void delete(StaffDTO productDTO);

  StaffEntity findStaffById(Long id);

  StaffEntity update(StaffDTO productDTO);
}
