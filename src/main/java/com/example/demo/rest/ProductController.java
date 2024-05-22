package com.example.demo.rest;

import com.example.demo.repository.Artisan;
import com.example.demo.repository.Product;
import com.example.demo.service.ArtisanService;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    ArtisanService artisanService;

    //Get all available products
    @GetMapping
    List<Product> getProducts() {
        return productService.getAllProducts();
    }

    //Get a product by id
    @GetMapping("/{id}")
    Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }


    //Delete a product by id
    @DeleteMapping("/{id}")
    void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
