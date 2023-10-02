package com.company.product.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.company.product.entities.Category;
import com.company.product.repository.CategoryRepository;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    
     public List<Category> getCategoriesWithPagination(int page, int pageSize) {
        // Pageable pageable = PageRequest.of(page, pageSize);
        Pageable paging = PageRequest.of(page, pageSize);
        Page<Category> pagedResult = categoryRepository.findAll(paging);
        return pagedResult.toList();
    }

    public Category save(Category category){
        return this.categoryRepository.save(category);
    }

    public Category findById(Long id){
        Optional<Category> category =  this.categoryRepository.findById(id);
        return category.get();
    }

    public void deleteById(Long id){
        this.categoryRepository.deleteById(id);
    }


}
