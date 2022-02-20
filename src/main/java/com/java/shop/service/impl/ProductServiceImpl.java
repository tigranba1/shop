package com.java.shop.service.impl;

import com.java.shop.dto.ProductDTO;
import com.java.shop.entity.Category;
import com.java.shop.entity.Product;
import com.java.shop.enums.Status;
import com.java.shop.exceptions.ResourceNotFoundException;
import com.java.shop.repository.CategoryRepository;
import com.java.shop.repository.ProductRepository;
import com.java.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public Product getById(long id) {
        return productRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product not found"));
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findByName(String name) {
        if (name != null){
            return productRepository.findByName(name);
        }else{
            throw new ResourceNotFoundException("Product not found");
        }
    }

    @Override
    public List<Product> searchByPrice(Double minPrice, Double maxPrice) {
        //TODO to be done later
        return null;
    }

    @Override
    public List<Product> searchByCategory(int id) {
        if (id != 0) {

        return productRepository.findByCategoryId(id);
    }else{
            throw new ResourceNotFoundException("Products not found");
        }
    }

    @Override
    public Product addNewProduct(@NotNull ProductDTO productDTO) {
        if (productDTO.getName()==null || productDTO.getName().trim().isEmpty()){
            throw new ResourceNotFoundException("Product name is empty.");
        }
        Category category = null;
        try {
            category=categoryRepository.findById(productDTO.getCategoryID()).orElseThrow(EntityNotFoundException::new);
        }catch (EntityNotFoundException ex){
            ex.printStackTrace();
        }
        Product product = new Product(productDTO.getName(),productDTO.getPrice(),category);
       product = productRepository.save(product);
        System.out.println("Product " + product.getName()+ " with category " +category.getName()+" has been added");
        return product;
    }

    @Override
    public Status update(ProductDTO productDTO) {
        Product product = null;
        Category category = null;
        try {
            product = productRepository.findById(productDTO.getId()).orElseThrow(EntityNotFoundException::new);
            System.out.println("The product " + productDTO.getName() + " with id " + productDTO.getId() + " is updating...");
        }catch (EntityNotFoundException e){
            e.printStackTrace();
        }

        try{
            category = categoryRepository.findById(productDTO.getCategoryID()).orElseThrow(EntityNotFoundException::new);
        }
        catch (EntityNotFoundException e){
            e.printStackTrace();
        }
        if (category != null && product != null){
            product.setName(productDTO.getName());
            product.setPrice(productDTO.getPrice());
            product.setCategory(category);

            productRepository.save(product);
            return Status.SUCCESS;
        }
        else{
            throw new ResourceNotFoundException("Product not found");
        }
    }

    @Override
    public void remove(Long id) {
productRepository.deleteById(id);
    }
}
