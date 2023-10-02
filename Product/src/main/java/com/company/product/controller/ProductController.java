package com.company.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.product.beans.ProductBean;
import com.company.product.entities.Product;
import com.company.product.services.ProductService;
@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> findAll(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "10") int pageSize){
       List<Product> categories =  this.productService.getProductsWithPagination(page,pageSize);
       return ResponseEntity.ok().body(categories);
    }

    @PostMapping("/products")
    public ResponseEntity<Product> save(@RequestBody ProductBean product){
       return ResponseEntity.ok().body(this.productService.save(product));
    }

    @GetMapping("/products/{id}")
     public ResponseEntity<Product> getById(@PathVariable("id") Long id){
       return ResponseEntity.ok().body(this.productService.findById(id));
    }
   
    @DeleteMapping("/products/{id}")
     public ResponseEntity<?> deleteById(@PathVariable("id") Long id){
       this.productService.deleteById(id);
       return ResponseEntity.ok().body(null);
    }

    @PutMapping("/products/{id}")
public ResponseEntity<Product> update(@RequestBody ProductBean product,@PathVariable("id")Long product_id){
       return ResponseEntity.ok().body(this.productService.update(product,product_id));
    }
}
