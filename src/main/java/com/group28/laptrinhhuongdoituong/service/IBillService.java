package com.group28.laptrinhhuongdoituong.service;

import com.group28.laptrinhhuongdoituong.dto.BillDTO;
import com.group28.laptrinhhuongdoituong.entity.BillEntity;

import java.util.List;

public interface IBillService {
    BillEntity save(BillDTO bill);
    List<BillEntity> listBill();
    List<BillEntity> listBill(String keyWord);
    void delete(BillDTO billDTO);
    BillEntity findBillById(Long id);
}
