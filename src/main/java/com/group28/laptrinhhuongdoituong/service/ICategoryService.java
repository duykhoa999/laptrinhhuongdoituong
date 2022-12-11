package com.group28.laptrinhhuongdoituong.service;

import com.group28.laptrinhhuongdoituong.dto.CategoryDTO;
import com.group28.laptrinhhuongdoituong.dto.ProductDTO;
import com.group28.laptrinhhuongdoituong.entity.CategoryEntity;
import com.group28.laptrinhhuongdoituong.entity.ProductEntity;

import java.util.List;

public interface ICategoryService {
    CategoryEntity save(CategoryDTO category);

    List<CategoryDTO> listCategory();

    List<CategoryDTO> listCategory(String keyWord);

    void delete(CategoryDTO categoryDTO);

    CategoryDTO findCategoryById(Long id);
}
