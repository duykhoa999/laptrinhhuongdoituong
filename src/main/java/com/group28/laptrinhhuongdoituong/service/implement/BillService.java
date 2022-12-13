package com.group28.laptrinhhuongdoituong.service.implement;

import com.group28.laptrinhhuongdoituong.converter.BillConverter;
import com.group28.laptrinhhuongdoituong.dto.BillDTO;
import com.group28.laptrinhhuongdoituong.entity.BillEntity;
import com.group28.laptrinhhuongdoituong.repository.BillRepository;
import com.group28.laptrinhhuongdoituong.service.IBillService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class BillService implements IBillService {
    @Autowired
    private final BillRepository billRepository;

    private BillConverter billConverter;

    @Override
    public BillEntity save(BillDTO billDTO) {
        return billRepository.save(billConverter.toEntity(billDTO));
    }

    @Override
    public List<BillEntity> listBill() {
        List<BillEntity> list = billRepository.findAll();
        // List<BillDTO> listDTO = new ArrayList<>();
        // for (BillEntity item: list) {
        //     if(!BooleanUtils.isTrue(item.getDeleted())){
        //         BillDTO dto = billConverter.toDTO(item);
        //         listDTO.add(dto);
        //     }
        // }
        return list.stream().filter(item -> BooleanUtils.isFalse(item.getDeleted())).collect(Collectors.toList());
    }

    @Override
    public void delete(BillDTO billDTO) {
        billRepository.delete(billConverter.toEntity(billDTO));
    }

    @Override
    public BillEntity findBillById(Long id) {
        if(billRepository.findById(id).isEmpty()) {
            return null;
        }
        return billRepository.findById(id).get();
    }

    @Override
    public List<BillEntity> listBill(String keyWord) {
        // TODO Auto-generated method stub
        return null;
    }
}
