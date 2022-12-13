package com.group28.laptrinhhuongdoituong.service;

import com.group28.laptrinhhuongdoituong.dto.ProductDTO;
import com.group28.laptrinhhuongdoituong.entity.ProductEntity;

import java.util.List;

public interface IProductService {
    ProductEntity save(ProductDTO productDTO);
    List<ProductEntity> listProduct();
    List<ProductEntity> listProduct(String keyWord);
    void delete(ProductDTO productDTO);
    ProductEntity findProductById(Long id);
    ProductEntity update(ProductDTO productDTO);
}
