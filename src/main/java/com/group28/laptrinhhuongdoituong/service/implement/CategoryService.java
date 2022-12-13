package com.group28.laptrinhhuongdoituong.service.implement;

import com.group28.laptrinhhuongdoituong.converter.CategoryConverter;
import com.group28.laptrinhhuongdoituong.dto.CategoryDTO;
import com.group28.laptrinhhuongdoituong.entity.CategoryEntity;
import com.group28.laptrinhhuongdoituong.repository.CategoryRepository;
import com.group28.laptrinhhuongdoituong.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryService implements ICategoryService {

    @Autowired
    private final CategoryRepository categoryRepository;

    @Autowired
    private CategoryConverter categoryConverter;

    @Override
    public CategoryEntity save(CategoryDTO categoryDTO) {
        return categoryRepository.save(categoryConverter.toEntity(categoryDTO));
    }

    @Override
    public List<CategoryEntity> listCategory() {
        List<CategoryEntity> list = categoryRepository.findAll();
        // List<CategoryDTO> listDTO = new ArrayList<>();
        // for (CategoryEntity item: list) {
        //     if(!BooleanUtils.isTrue(item.getDeleted())){
        //         CategoryDTO dto = categoryConverter.toDTO(item);
        //         listDTO.add(dto);
        //     }
        // }
        return list.stream().filter(item -> BooleanUtils.isFalse(item.getDeleted())).collect(Collectors.toList());
    }

    @Override
    public List<CategoryEntity> listCategory(String keyWord) {
        List<CategoryEntity> list = categoryRepository.search(keyWord);
        // List<CategoryDTO> listDTO = new ArrayList<>();
        // for (CategoryEntity item: list) {
        //     if(!BooleanUtils.isTrue(item.getDeleted())){
        //         CategoryDTO dto = categoryConverter.toDTO(item);
        //         listDTO.add(dto);
        //     }
        // }
        return list.stream().filter(item -> BooleanUtils.isFalse(item.getDeleted())).collect(Collectors.toList());
    }

    @Override
    public void delete(CategoryDTO categoryDTO) {
        categoryRepository.delete(categoryConverter.toEntity(categoryDTO));
    }

    @Override
    public CategoryEntity findCategoryById(Long id) {
        if(categoryRepository.findById(id).isEmpty()) {
            return null;
        }
        return categoryRepository.findById(id).get();
    }
}
