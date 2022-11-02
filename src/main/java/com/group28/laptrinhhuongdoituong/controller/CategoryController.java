package com.group28.laptrinhhuongdoituong.controller;

import com.group28.laptrinhhuongdoituong.dto.CategoryDTO;
import com.group28.laptrinhhuongdoituong.entity.CategoryEntity;
import com.group28.laptrinhhuongdoituong.response.ResponseHandler;
import com.group28.laptrinhhuongdoituong.service.implement.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    public static Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<?> listAllCategory(){
        List<CategoryDTO> listCategory = categoryService.listCategory();
        if(listCategory.isEmpty()) {
            return ResponseHandler.generateResponse("list category is empty", HttpStatus.OK, "");
        }
        return ResponseHandler.generateResponse("Get list category successfully", HttpStatus.OK, listCategory);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findCategory(@PathVariable("id") Long id) {
        CategoryDTO category = categoryService.findCategoryById(id);
        if(category == null) {
            return ResponseHandler.generateResponse("Get category successfully", HttpStatus.OK, "");
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
        CategoryDTO category = categoryService.findCategoryById(id);
        categoryService.delete(category);
        return ResponseHandler.generateResponse("Delete category successfully", HttpStatus.OK, category);
    }
}
