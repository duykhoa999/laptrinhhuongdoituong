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
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryService implements ICategoryService {

    @Autowired
    private final CategoryRepository categoryRepository;

    private final CategoryConverter categoryConverter;

    @Override
    public CategoryEntity save(CategoryDTO categoryDTO) {
        return categoryRepository.save(categoryConverter.toEntity(categoryDTO));
    }

    @Override
    public List<CategoryDTO> listCategory() {
        List<CategoryEntity> list = categoryRepository.findAll();
        List<CategoryDTO> listDTO = new ArrayList<>();
        for (CategoryEntity item: list) {
            if(!BooleanUtils.isTrue(item.getDeleted())){
                CategoryDTO dto = categoryConverter.toDTO(item);
                listDTO.add(dto);
            }
        }
        return listDTO;
    }

    @Override
    public List<CategoryDTO> listCategory(String keyWord) {
        List<CategoryEntity> list = categoryRepository.search(keyWord);
        List<CategoryDTO> listDTO = new ArrayList<>();
        for (CategoryEntity item: list) {
            if(!BooleanUtils.isTrue(item.getDeleted())){
                CategoryDTO dto = categoryConverter.toDTO(item);
                listDTO.add(dto);
            }
        }
        return listDTO;
    }

    @Override
    public void delete(CategoryDTO categoryDTO) {
        categoryRepository.delete(categoryConverter.toEntity(categoryDTO));
    }

    @Override
    public CategoryDTO findCategoryById(Long id) {
        CategoryDTO categoryDTO = new CategoryDTO();
        if(categoryRepository.findById(id).isEmpty()) {
            return null;
        }
        categoryDTO = categoryConverter.toDTO(categoryRepository.findById(id).get());
        return categoryDTO;
    }
}
