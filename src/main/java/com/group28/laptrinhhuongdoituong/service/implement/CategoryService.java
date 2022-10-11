package com.group28.laptrinhhuongdoituong.service.implement;

import com.group28.laptrinhhuongdoituong.entity.CategoryEntity;
import com.group28.laptrinhhuongdoituong.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryEntity create(CategoryEntity category) {
        return categoryRepository.save(category);
    }

    public void remove(Long id){
        categoryRepository.deleteById(id);
    }

    public Iterable<CategoryEntity> findAll(){
        return categoryRepository.findAll();
    }

    public Optional<CategoryEntity> findOneById(long id){
        return categoryRepository.findById(id);
    }
}
