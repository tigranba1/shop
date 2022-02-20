package com.java.shop.controller;

import com.java.shop.api.ProductAPI;
import com.java.shop.dto.ProductDTO;
import com.java.shop.entity.Product;
import com.java.shop.enums.Status;
import com.java.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ProductController implements ProductAPI {
   @Autowired
   ProductService productService ;


    @Override
    public Product addProduct(ProductDTO productDTO) {
        return productService.addNewProduct(productDTO);
    }

    @Override
    public Status updateProduct(ProductDTO productDTO) {
        return productService.update(productDTO);
    }

    @Override
    public void deleteProduct(Long id) {
productService.remove(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return productService.getAll();
    }

    @Override
    public List<Product> getProductsbyCategoryID(Integer id) {
        return productService.searchByCategory(id);
    }
}
