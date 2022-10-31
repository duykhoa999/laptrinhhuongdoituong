package com.group28.laptrinhhuongdoituong.converter;

import com.group28.laptrinhhuongdoituong.dto.BillDTO;
import com.group28.laptrinhhuongdoituong.entity.BillEntity;
import com.group28.laptrinhhuongdoituong.entity.CategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class BillConverter {
    public BillDTO toDTO(BillEntity billEntity) {
        BillDTO billDTO = new BillDTO();
        billDTO.setId(billEntity.getId());
        billDTO.setDate(billEntity.getDate());
        billDTO.setTotal(billEntity.getTotal());
        billDTO.setOrder_id(billEntity.getOrder_id());
        billDTO.setStaff_id(billEntity.getStaff_id());
        billDTO.setDeleted(billEntity.getDeleted());

        return billDTO;
    }

    public BillEntity toEntity(BillDTO billDTO) {
        BillEntity billEntity = new BillEntity();
        billEntity.setId(billDTO.getId());
        billEntity.setDate(billDTO.getDate());
        billEntity.setTotal(billDTO.getTotal());
        billEntity.setOrder_id(billDTO.getOrder_id());
        billEntity.setStaff_id(billDTO.getStaff_id());
        billEntity.setDeleted(billDTO.getDeleted());

        return billEntity;
    }
}
