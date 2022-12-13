package com.group28.laptrinhhuongdoituong.controller;

import com.group28.laptrinhhuongdoituong.converter.BillConverter;
import com.group28.laptrinhhuongdoituong.dto.BillDTO;
import com.group28.laptrinhhuongdoituong.dto.Keyword;
import com.group28.laptrinhhuongdoituong.entity.BillEntity;
import com.group28.laptrinhhuongdoituong.response.ResponseHandler;
import com.group28.laptrinhhuongdoituong.service.implement.BillService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/bill")
public class BillController {
    @Autowired
    private BillService billService;

    @Autowired
    private BillConverter billConverter;

    @GetMapping
    public ResponseEntity<?> listAllBill(@RequestBody Keyword keyword) {
        List<BillEntity> listBill = new ArrayList<>();
        if (StringUtils.isNotBlank(keyword.getKeyword())) {
            listBill = billService.listBill(keyword.getKeyword());
        } else {
            listBill = billService.listBill();
        }
        if (listBill.isEmpty()) {
            return ResponseHandler.generateResponse("list bill is empty", HttpStatus.OK, new ArrayList<>());
        }
        return ResponseHandler.generateResponse("Get list bill successfully", HttpStatus.OK, listBill);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findBill(@PathVariable("id") Long id) {
        BillEntity bill = billService.findBillById(id);
        if (bill == null) {
            return ResponseHandler.generateResponse("Bill not found", HttpStatus.OK, null);
        }
        return ResponseHandler.generateResponse("Get bill successfully", HttpStatus.OK, bill);
    }

    //
    @PostMapping
    public ResponseEntity<?> saveBill(@Valid @RequestBody BillDTO bill) {
        BillEntity billEntity = billService.save(bill);
        return ResponseHandler.generateResponse("add bill successfully", HttpStatus.OK, billEntity);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteBill(@PathVariable("id") Long id) {
        BillEntity billEntity = billService.findBillById(id);
        if(billEntity == null) {
            return ResponseHandler.generateResponse("Bill not found", HttpStatus.OK, null);
        }
        billService.delete(billConverter.toDTO(billEntity));
        return ResponseHandler.generateResponse("Delete category successfully", HttpStatus.OK, billEntity);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateBill(@PathVariable("id") Long id, @Valid @RequestBody BillDTO billDTO) {
        BillEntity billEntity = billService.findBillById(id);
        if (billEntity == null) {
            return ResponseHandler.generateResponseErr(HttpStatus.OK, "cannot find category by id: " + id);
        }
        billDTO.setId(id);
        BillEntity entity = billService.save(billDTO);
        return ResponseHandler.generateResponse("Update bill successfully", HttpStatus.OK, entity);
    }
}
