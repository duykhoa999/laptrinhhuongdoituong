package com.group28.laptrinhhuongdoituong.service;

import com.group28.laptrinhhuongdoituong.dto.CategoryDTO;
import com.group28.laptrinhhuongdoituong.entity.CategoryEntity;
import java.util.List;

public interface ICategoryService {
    CategoryEntity save(CategoryDTO category);
    List<CategoryEntity> listCategory();
    List<CategoryEntity> listCategory(String keyWord);
    void delete(CategoryDTO categoryDTO);
    CategoryEntity findCategoryById(Long id);
}
