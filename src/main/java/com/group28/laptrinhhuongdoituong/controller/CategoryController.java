package com.group28.laptrinhhuongdoituong.controller;

import com.group28.laptrinhhuongdoituong.entity.CategoryEntity;
import com.group28.laptrinhhuongdoituong.service.implement.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CategoryController {
    public static Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/category/", method = RequestMethod.GET)
    public ResponseEntity<List<CategoryEntity>> listAllCategory(){
        List<CategoryEntity> listCategory= (List<CategoryEntity>) categoryService.findAll();
        if(listCategory.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<CategoryEntity>>(listCategory, HttpStatus.OK);
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<CategoryEntity>> findCategory(@PathVariable("id") long id) {
        Optional<CategoryEntity> category = categoryService.findOneById(id);
        if(category.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Optional<CategoryEntity>>(category, HttpStatus.OK);
    }

    @RequestMapping(value = "/category/", method = RequestMethod.POST)
    public CategoryEntity saveCategory(CategoryEntity category) {

        return categoryService.create(category);
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCategory(@PathVariable("id") long id) {
        try {
            categoryService.remove(id);
            return ResponseEntity.ok("Success");
        }catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
