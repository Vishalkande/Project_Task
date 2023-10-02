package com.company.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.product.entities.Category;
import com.company.product.services.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    
    @Autowired
    CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> findAll(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "10") int pageSize){
       List<Category> categories =  this.categoryService.getCategoriesWithPagination(page,pageSize);
       return ResponseEntity.ok().body(categories);
    }

    @PostMapping
    public ResponseEntity<Category> save(@RequestBody Category category){
       return ResponseEntity.ok().body(this.categoryService.save(category));
    }

    @GetMapping("/{id}")
     public ResponseEntity<Category> getById(@PathVariable("id") Long id){
       return ResponseEntity.ok().body(this.categoryService.findById(id));
    }

    @DeleteMapping("/{id}")
     public ResponseEntity<?> deleteById(@PathVariable("id") Long id){
       this.categoryService.deleteById(id);
       return ResponseEntity.ok().body(null);
    }
}
