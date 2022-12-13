package com.group28.laptrinhhuongdoituong.service.implement;

import com.group28.laptrinhhuongdoituong.converter.ProductConverter;
import com.group28.laptrinhhuongdoituong.dto.ProductDTO;
import com.group28.laptrinhhuongdoituong.entity.ProductEntity;
import com.group28.laptrinhhuongdoituong.repository.ProductRepository;
import com.group28.laptrinhhuongdoituong.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService implements IProductService {

    @Autowired
    private final ProductRepository productRepository;
    @Autowired
    private ProductConverter productConverter;

    @Override
    public ProductEntity save(ProductDTO productDTO) {
        return productRepository.save(productConverter.toEntity(productDTO));
    }

    @Override
    public List<ProductEntity> listProduct() {
        List<ProductEntity> list = productRepository.findAll();
        // List<ProductDTO> listDTO = new ArrayList<>();
        // for (ProductEntity item: list) {
        //     if(!BooleanUtils.isTrue(item.getDeleted())){
        //         ProductDTO dto = productConverter.toDTO(item);
        //         listDTO.add(dto);
        //     }
        // }
        return list.stream().filter(item -> BooleanUtils.isFalse(item.getDeleted())).collect(Collectors.toList());
    }

    @Override
    public void delete(ProductDTO productDTO) {
        productRepository.delete(productConverter.toEntity(productDTO));
    }

    @Override
    public ProductEntity findProductById(Long id) {
        if(productRepository.findById(id).isEmpty()) {
            return null;
        }
        return productRepository.findById(id).get();
    }

    @Override
    public ProductEntity update(ProductDTO productDTO) {
        return productRepository.save(productConverter.toEntity(productDTO));
    }

    @Override
    public List<ProductEntity> listProduct(String keyWord) {
        List<ProductEntity> list = productRepository.search(keyWord);
        return list.stream().filter(item -> BooleanUtils.isFalse(item.getDeleted())).collect(Collectors.toList());
    }
}
