package com.company.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.company.product.entities.Category;
import com.company.product.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>,PagingAndSortingRepository<Product, Long> {
}
