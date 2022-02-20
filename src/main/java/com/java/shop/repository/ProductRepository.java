package com.java.shop.repository;

import com.java.shop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByName(String name);
    List<Product> findByCategoryId(int id);
}
