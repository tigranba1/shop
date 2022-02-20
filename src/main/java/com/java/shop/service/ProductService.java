package com.java.shop.service;

import com.java.shop.dto.ProductDTO;
import com.java.shop.entity.Product;
import com.java.shop.enums.Status;

import java.util.List;

public interface ProductService {
    Product getById(long id);
    List<Product> getAll();
    List<Product> findByName(String name);
    List<Product> searchByPrice(Double minPrice, Double maxPrice);
    List<Product> searchByCategory(int categoryid);
    Product addNewProduct(ProductDTO productDTO);
    Status update(ProductDTO productDTO);
    void remove(Long id);
}
