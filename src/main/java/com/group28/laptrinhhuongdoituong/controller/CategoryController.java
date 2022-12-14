package com.group28.laptrinhhuongdoituong.controller;

import com.group28.laptrinhhuongdoituong.converter.CategoryConverter;
import com.group28.laptrinhhuongdoituong.dto.CategoryDTO;
import com.group28.laptrinhhuongdoituong.dto.Keyword;
import com.group28.laptrinhhuongdoituong.entity.CategoryEntity;
import com.group28.laptrinhhuongdoituong.response.ResponseHandler;
import com.group28.laptrinhhuongdoituong.service.implement.CategoryService;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    public static Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryConverter categoryConverter;

    @GetMapping
    public ResponseEntity<?> listAllCategory(@RequestBody Keyword keyword){
        List<CategoryEntity> listCategory = new ArrayList<>();
        if (StringUtils.isNotBlank(keyword.getKeyword())) {
            listCategory = categoryService.listCategory(keyword.getKeyword());
        } else {
            listCategory = categoryService.listCategory();
        }
        if(listCategory.isEmpty()) {
            return ResponseHandler.generateResponse("list category is empty", HttpStatus.OK, new ArrayList<>());
        }
        return ResponseHandler.generateResponse("Get list category successfully", HttpStatus.OK, listCategory);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findCategory(@PathVariable("id") Long id) {
        CategoryEntity category = categoryService.findCategoryById(id);
        if(category == null) {
            return ResponseHandler.generateResponse("category not found", HttpStatus.OK, null);
        }
        return ResponseHandler.generateResponse("Get category successfully", HttpStatus.OK, category);
    }

    @PostMapping
    public ResponseEntity<Object> saveCategory(@Valid @RequestBody CategoryDTO category) {
        CategoryEntity entity = categoryService.save(category);
        return ResponseHandler.generateResponse("add category successfully", HttpStatus.OK, entity);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable("id") Long id) {
        CategoryEntity category = categoryService.findCategoryById(id);
        if(category == null) {
            return ResponseHandler.generateResponse("category not found", HttpStatus.OK, null);
        }
        categoryService.delete(categoryConverter.toDTO(category));
        return ResponseHandler.generateResponse("Delete category successfully", HttpStatus.OK, category);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable("id") Long id, @Valid @RequestBody CategoryDTO category) {
        CategoryEntity categoryById = categoryService.findCategoryById(id);
        if (categoryById == null) {
            return ResponseHandler.generateResponseErr(HttpStatus.OK, "cannot find category by id: " + id);
        }
        category.setId(id);
        CategoryEntity entity = categoryService.save(category);
        return ResponseHandler.generateResponse("Update category successfully", HttpStatus.OK, entity);
    }
}
