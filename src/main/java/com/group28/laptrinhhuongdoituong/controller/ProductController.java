package com.group28.laptrinhhuongdoituong.controller;

import com.group28.laptrinhhuongdoituong.converter.ProductConverter;
import com.group28.laptrinhhuongdoituong.dto.ProductDTO;
import com.group28.laptrinhhuongdoituong.entity.ProductEntity;
import com.group28.laptrinhhuongdoituong.response.ResponseHandler;
import com.group28.laptrinhhuongdoituong.service.implement.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    private ProductConverter productConverter;

    @GetMapping
    public ResponseEntity<Object> listAllProduct(){
        List<ProductEntity> listProduct = productService.listProduct();
        if(listProduct.isEmpty()) {
            return ResponseHandler.generateResponse("list product is empty", HttpStatus.OK, new ArrayList<>());
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
        ProductEntity product = productService.findProductById(id);
        productService.delete(productConverter.toDTO(product));
        return ResponseHandler.generateResponse("Delete product successfully", HttpStatus.OK, product);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable("id") Long id, @Valid @RequestBody ProductDTO productDTO) {
        productDTO.setId(id);
        ProductEntity productById = productService.findProductById(id);
        if (productById == null) {
            return ResponseHandler.generateResponseErr(HttpStatus.OK, "cannot find product with id: " + id);
        }
        ProductEntity productEntity = productService.save(productDTO);
        return ResponseHandler.generateResponse("update product successfully", HttpStatus.OK, productEntity);
    }
}
