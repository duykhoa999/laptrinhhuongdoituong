package com.group28.laptrinhhuongdoituong.service;

import com.group28.laptrinhhuongdoituong.dto.CategoryDTO;
import com.group28.laptrinhhuongdoituong.entity.CategoryEntity;

import java.util.List;

public interface ICategoryService {
    CategoryEntity save(CategoryDTO category);

    List<CategoryDTO> listCategory();

    void delete(CategoryDTO categoryDTO);

    CategoryDTO findCategoryById(int id);
}
