package com.group28.laptrinhhuongdoituong.service;

import com.group28.laptrinhhuongdoituong.dto.BillDTO;
import com.group28.laptrinhhuongdoituong.dto.CategoryDTO;
import com.group28.laptrinhhuongdoituong.entity.BillEntity;
import com.group28.laptrinhhuongdoituong.entity.CategoryEntity;

import java.util.List;

public interface IBillService {
    BillEntity save(BillDTO bill);

    List<BillDTO> listBill();

    void delete(BillDTO billDTO);

    BillDTO findBillById(Long id);
}
