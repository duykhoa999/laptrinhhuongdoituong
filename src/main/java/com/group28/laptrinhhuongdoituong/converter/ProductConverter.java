package com.group28.laptrinhhuongdoituong.converter;

import com.group28.laptrinhhuongdoituong.dto.ProductDTO;
import com.group28.laptrinhhuongdoituong.entity.ProductEntity;
import com.group28.laptrinhhuongdoituong.repository.CategoryRepository;
import com.group28.laptrinhhuongdoituong.service.implement.CategoryService;
import com.group28.laptrinhhuongdoituong.service.implement.VendorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    @Autowired
    private static CategoryService categoryService;

    @Autowired
    private static VendorService vendorService;

    public static ProductDTO toDTO(ProductEntity productEntity) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(productEntity.getId());
        productDTO.setName(productEntity.getName());
        productDTO.setSlug(productEntity.getSlug());
        productDTO.setPrice(productEntity.getPrice());
        productDTO.setDescription(productEntity.getDescription());
        productDTO.setImage(productEntity.getImage());
        productDTO.setAmount(productEntity.getAmount());
        productDTO.setCategory_id(productEntity.getCategory().getId());
        productDTO.setVendor_id(productEntity.getVendor().getId());
        productDTO.setDeleted(productEntity.getDeleted());
        return productDTO;
    }

    public static ProductEntity toEntity(ProductDTO productDTO) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(productDTO.getId());
        productEntity.setName(productDTO.getName());
        productEntity.setSlug(productDTO.getSlug());
        productEntity.setPrice(productDTO.getPrice());
        productEntity.setDescription(productDTO.getDescription());
        productEntity.setImage(productDTO.getImage());
        productEntity.setAmount(productDTO.getAmount());
        productEntity.setCategory(categoryService.findCategoryById(productDTO.getCategory_id()));
        productEntity.setVendor(vendorService.findVendorById(productDTO.getVendor_id()));
        productEntity.setDeleted(productDTO.getDeleted());
        return productEntity;
    }
}
