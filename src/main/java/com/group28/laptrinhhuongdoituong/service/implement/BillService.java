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

@Service
@RequiredArgsConstructor
@Transactional
public class BillService implements IBillService {
    @Autowired
    private final BillRepository billRepository;

    private final BillConverter billConverter;

    @Override
    public BillEntity save(BillDTO billDTO) {
        return billRepository.save(billConverter.toEntity(billDTO));
    }

    @Override
    public List<BillDTO> listBill() {
        List<BillEntity> list = billRepository.findAll();
        List<BillDTO> listDTO = new ArrayList<>();
        for (BillEntity item: list) {
            if(!BooleanUtils.isTrue(item.getDeleted())){
                BillDTO dto = billConverter.toDTO(item);
                listDTO.add(dto);
            }
        }
        return listDTO;
    }

    @Override
    public void delete(BillDTO billDTO) {
        billRepository.delete(billConverter.toEntity(billDTO));
    }

    @Override
    public BillDTO findBillById(Long id) {
        BillDTO billDTO = new BillDTO();
        if(billRepository.findById(id).isEmpty()) {
            return billDTO;
        }
        billDTO = billConverter.toDTO(billRepository.findById(id).get());
        return billDTO;
    }
}
