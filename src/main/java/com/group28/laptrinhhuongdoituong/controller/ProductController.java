package com.group28.laptrinhhuongdoituong.controller;

import com.group28.laptrinhhuongdoituong.converter.ProductConverter;
import com.group28.laptrinhhuongdoituong.dto.Keyword;
import com.group28.laptrinhhuongdoituong.dto.ProductDTO;
import com.group28.laptrinhhuongdoituong.entity.ProductEntity;
import com.group28.laptrinhhuongdoituong.response.ResponseHandler;
import com.group28.laptrinhhuongdoituong.service.implement.ProductService;

import org.apache.commons.lang3.StringUtils;
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

    @Autowired
    private ProductConverter productConverter;

    @GetMapping
    public ResponseEntity<Object> listAllProduct(@RequestBody Keyword keyword) {
        List<ProductEntity> listProduct = new ArrayList<>();
        if (StringUtils.isNotBlank(keyword.getKeyword())) {
            listProduct = productService.listProduct(keyword.getKeyword());
        } else {
            listProduct = productService.listProduct();
        }
        if (listProduct.isEmpty()) {
            return ResponseHandler.generateResponse("list product is empty", HttpStatus.OK, new ArrayList<>());
        }
        return ResponseHandler.generateResponse("Get product successfully", HttpStatus.OK, listProduct);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findProduct(@PathVariable("id") Long id) {
        ProductEntity entity = productService.findProductById(id);
        if (entity == null) {
            return ResponseHandler.generateResponse("Product not found", HttpStatus.OK, null);
        }
        return ResponseHandler.generateResponse("Get Product successfully", HttpStatus.OK, entity);
    }

    @PostMapping
    public ResponseEntity<?> saveProduct(@Valid @RequestBody ProductDTO productDTO) {
        ProductEntity productEntity = productService.save(productDTO);
        return ResponseHandler.generateResponse("add product successfully", HttpStatus.OK, productEntity);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id) {
        ProductEntity product = productService.findProductById(id);
        if (product == null) {
            return ResponseHandler.generateResponse("Product not found", HttpStatus.OK, null);
        }
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
