package com.company.product.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.company.product.beans.ProductBean;
import com.company.product.entities.Category;
import com.company.product.entities.Product;
import com.company.product.repository.CategoryRepository;
import com.company.product.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryService categoryService;
    
     public List<Product> getProductsWithPagination(int page, int pageSize) {
        // Pageable pageable = PageRequest.of(page, pageSize);
        Pageable paging = PageRequest.of(page, pageSize);
        Page<Product> pagedResult = productRepository.findAll(paging);
        return pagedResult.toList();
    }

    public Product save(ProductBean productBean){
        Product product = new Product();
        BeanUtils.copyProperties(productBean, product);
        Category category =  this.categoryService.findById(productBean.getCategoryId());
        product.setCategory(category);
        return this.productRepository.save(product);
    }
    public Product update(ProductBean productBean,Long productId){

        Product product =  this.productRepository.findById(productId).get();
        BeanUtils.copyProperties(productBean, product);
        return this.productRepository.save(product);
    }
    public Product findById(Long id){
        Optional<Product> product =  this.productRepository.findById(id);
        return product.get();
    }

    public void deleteById(Long id){
         this.productRepository.deleteById(id);
    }
}
