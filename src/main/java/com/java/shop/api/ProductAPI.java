package com.java.shop.api;

import com.java.shop.dto.ProductDTO;
import com.java.shop.entity.Product;
import com.java.shop.enums.Status;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@PreAuthorize("hadAuthority('ADMIN')")
@RequestMapping ("/product/")
public interface ProductAPI {

    @PostMapping("add-product")
    public Product addProduct(@Valid @RequestBody ProductDTO productDTO);

    @PostMapping("edit-product")
    public Status updateProduct(@Valid @RequestBody ProductDTO productDTO);

    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable Long id);

    @GetMapping("all")
    public List<Product> getAllProducts();

    @GetMapping("category/{id}")
    public List<Product> getProductsbyCategoryID(@PathVariable Integer id);
}
