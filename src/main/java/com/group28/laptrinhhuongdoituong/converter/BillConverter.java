package com.group28.laptrinhhuongdoituong.converter;

import com.group28.laptrinhhuongdoituong.dto.BillDTO;
import com.group28.laptrinhhuongdoituong.entity.BillEntity;
import com.group28.laptrinhhuongdoituong.entity.CategoryEntity;
import com.group28.laptrinhhuongdoituong.service.implement.OrderService;
import com.group28.laptrinhhuongdoituong.service.implement.StaffService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BillConverter {

    @Autowired
    private static OrderService orderService;

    @Autowired
    private static StaffService staffService;

    public static BillDTO toDTO(BillEntity billEntity) {
        BillDTO billDTO = new BillDTO();
        billDTO.setId(billEntity.getId());
        billDTO.setDate(billEntity.getDate());
        billDTO.setTotal(billEntity.getTotal());
        billDTO.setOrder_id(billEntity.getOrder().getId());
        billDTO.setStaff_id(billEntity.getStaff().getId());
        billDTO.setDeleted(billEntity.getDeleted());

        return billDTO;
    }

    public static BillEntity toEntity(BillDTO billDTO) {
        BillEntity billEntity = new BillEntity();
        billEntity.setId(billDTO.getId());
        billEntity.setDate(billDTO.getDate());
        billEntity.setTotal(billDTO.getTotal());
        billEntity.setOrder(orderService.findOrderById(billDTO.getOrder_id()));
        billEntity.setStaff(staffService.findStaffById(billDTO.getStaff_id()));
        billEntity.setDeleted(billDTO.getDeleted());

        return billEntity;
    }
}
