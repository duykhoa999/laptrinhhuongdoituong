package com.group28.laptrinhhuongdoituong.controller;

import com.group28.laptrinhhuongdoituong.converter.BillConverter;
import com.group28.laptrinhhuongdoituong.dto.BillDTO;
import com.group28.laptrinhhuongdoituong.entity.BillEntity;
import com.group28.laptrinhhuongdoituong.service.implement.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BillController {
    @Autowired
    private BillService billService;

    private BillConverter billConverter;

    @RequestMapping(value = "/bill/", method = RequestMethod.GET)
    public ResponseEntity<?> listAllBill(){
        List<BillEntity> listBill = billService.listBill();
        if(listBill.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listBill, HttpStatus.OK);
    }

    @RequestMapping(value = "/bill/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findBill(@PathVariable("id") Long id) {
        BillEntity bill = billService.findBillById(id);
//        if(category.isEmpty()) {
//            return new ResponseEntity(HttpStatus.NO_CONTENT);
//        }
        return new ResponseEntity<>(bill, HttpStatus.OK);
    }
    //
    @RequestMapping(value = "/bill/", method = RequestMethod.POST)
    public BillEntity saveBill(BillDTO bill) {

        return billService.save(bill);
    }

    @RequestMapping(value = "/bill/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteBill(@PathVariable("id") Long id) {
        try {
            BillEntity bill = billService.findBillById(id);
            billService.delete(billConverter.toDTO(bill));
            return ResponseEntity.ok("Success");
        }catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
