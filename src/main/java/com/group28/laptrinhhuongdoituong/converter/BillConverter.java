package com.group28.laptrinhhuongdoituong.converter;

import com.group28.laptrinhhuongdoituong.dto.BillDTO;
import com.group28.laptrinhhuongdoituong.entity.BillEntity;
import com.group28.laptrinhhuongdoituong.service.implement.OrderService;
import com.group28.laptrinhhuongdoituong.service.implement.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BillConverter {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    public BillDTO toDTO(BillEntity billEntity) {
        BillDTO billDTO = new BillDTO();
        billDTO.setId(billEntity.getId());
        billDTO.setCode(billEntity.getCode());
        billDTO.setDate(billEntity.getDate());
        billDTO.setTotal(billEntity.getTotal());
        billDTO.setOrder_id(billEntity.getOrder().getId());
        billDTO.setUser_id(billEntity.getUser().getId());
        billDTO.setDeleted(billEntity.getDeleted());

        return billDTO;
    }

    public BillEntity toEntity(BillDTO billDTO) {
        BillEntity billEntity = new BillEntity();
        billEntity.setId(billDTO.getId());
        billEntity.setCode(billDTO.getCode());
        billEntity.setDate(billDTO.getDate());
        billEntity.setTotal(billDTO.getTotal());
        billEntity.setOrder(orderService.findOrderById(billDTO.getOrder_id()));
        billEntity.setUser(userService.findUserById(billDTO.getUser_id()));
        billEntity.setDeleted(billDTO.getDeleted());

        return billEntity;
    }
}
