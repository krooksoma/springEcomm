package com.example.demo.dao;

import com.example.demo.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductsRepository extends JpaRepository<Product, Long> {
}
