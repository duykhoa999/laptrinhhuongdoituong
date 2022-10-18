package com.group28.laptrinhhuongdoituong.service.implement;

import com.group28.laptrinhhuongdoituong.converter.ProductConverter;
import com.group28.laptrinhhuongdoituong.dto.ProductDTO;
import com.group28.laptrinhhuongdoituong.entity.ProductEntity;
import com.group28.laptrinhhuongdoituong.repository.ProductRepository;
import com.group28.laptrinhhuongdoituong.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService implements IProductService {

    @Autowired
    private final ProductRepository productRepository;

    private final ProductConverter productConverter;

    @Override
    public ProductEntity save(ProductDTO productDTO) {
        return productRepository.save(productConverter.toEntity(productDTO));
    }

    @Override
    public List<ProductDTO> listProduct() {
        List<ProductEntity> list = productRepository.findAll();
        List<ProductDTO> listDTO = new ArrayList<>();
        for (ProductEntity item: list) {
            if(!BooleanUtils.isTrue(item.getDeleted())){
                ProductDTO dto = productConverter.toDTO(item);
                listDTO.add(dto);
            }
        }
        return listDTO;
    }

    @Override
    public void delete(ProductDTO productDTO) {

    }

    @Override
    public ProductDTO findProductById(Long id) {
        ProductDTO productDTO = new ProductDTO();
        if(productRepository.findById(id).isEmpty()) {
            return productDTO;
        }
        productDTO = productConverter.toDTO(productRepository.findById(id).get());
        return productDTO;
    }
}
