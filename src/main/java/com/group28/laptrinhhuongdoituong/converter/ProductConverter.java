package com.group28.laptrinhhuongdoituong.converter;

import com.group28.laptrinhhuongdoituong.dto.ProductDTO;
import com.group28.laptrinhhuongdoituong.entity.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    public ProductDTO toDTO(ProductEntity productEntity) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(productEntity.getId());
        productDTO.setName(productEntity.getName());
        productDTO.setSlug(productEntity.getSlug());
        productDTO.setPrice(productEntity.getPrice());
        productDTO.setDescription(productEntity.getDescription());
        productDTO.setImage(productEntity.getImage());
        productDTO.setAmount(productEntity.getAmount());
        productDTO.setCategory_id(productEntity.getCategory_id());
        productDTO.setVendor_id(productEntity.getVendor_id());
        productDTO.setDeleted(productEntity.getDeleted());
        return productDTO;
    }

    public ProductEntity toEntity(ProductDTO productDTO) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(productDTO.getId());
        productEntity.setName(productDTO.getName());
        productEntity.setSlug(productDTO.getSlug());
        productEntity.setPrice(productDTO.getPrice());
        productEntity.setDescription(productDTO.getDescription());
        productEntity.setImage(productDTO.getImage());
        productEntity.setAmount(productDTO.getAmount());
        productEntity.setCategory_id(productDTO.getCategory_id());
        productEntity.setVendor_id(productDTO.getVendor_id());
        productEntity.setDeleted(productDTO.getDeleted());
        return productEntity;
    }
}
