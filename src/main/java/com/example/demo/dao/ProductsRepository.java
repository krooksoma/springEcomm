package com.example.demo.dao;

import com.example.demo.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200") //without parenthesis parameter any origin will be allowed
public interface ProductsRepository extends JpaRepository<Product, Long> {
}
