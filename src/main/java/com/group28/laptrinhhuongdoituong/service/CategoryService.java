package com.group28.laptrinhhuongdoituong.service;

import com.group28.laptrinhhuongdoituong.model.Category;
import com.group28.laptrinhhuongdoituong.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    public void remove(Long id){
        categoryRepository.deleteById(id);
    }

    public Iterable<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Optional<Category> findOneById(long id){
        return categoryRepository.findById(id);
    }
}
