package com.group28.laptrinhhuongdoituong.service;

import com.group28.laptrinhhuongdoituong.dto.ProductDTO;
import com.group28.laptrinhhuongdoituong.entity.ProductEntity;

import java.util.List;

public interface IProductService {
    ProductEntity save(ProductDTO productDTO);
    List<ProductDTO> listProduct();
    void delete(ProductDTO productDTO);
    ProductDTO findProductById(Long id);
    ProductEntity update(ProductDTO productDTO);
}
