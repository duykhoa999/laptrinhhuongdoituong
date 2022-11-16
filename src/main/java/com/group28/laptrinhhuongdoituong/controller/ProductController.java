package com.group28.laptrinhhuongdoituong.controller;

import com.group28.laptrinhhuongdoituong.dto.CustomerDTO;
import com.group28.laptrinhhuongdoituong.dto.ProductDTO;
import com.group28.laptrinhhuongdoituong.entity.ProductEntity;
import com.group28.laptrinhhuongdoituong.response.ResponseHandler;
import com.group28.laptrinhhuongdoituong.service.implement.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<Object> listAllProduct(){
        List<ProductDTO> listProduct = productService.listProduct();
        if(listProduct.isEmpty()) {
            return ResponseHandler.generateResponse("list product is empty", HttpStatus.OK, "");
        }
        return ResponseHandler.generateResponse("Get product successfully", HttpStatus.OK, listProduct);
    }


    @PostMapping
    public ResponseEntity<?> saveProduct(@Valid @RequestBody ProductDTO productDTO) {
        ProductEntity productEntity = productService.save(productDTO);
        return ResponseHandler.generateResponse("add product successfully", HttpStatus.OK, productEntity);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id) {
        ProductDTO product = productService.findProductById(id);
        productService.delete(product);
        return ResponseHandler.generateResponse("Delete product successfully", HttpStatus.OK, product);
    }
}
