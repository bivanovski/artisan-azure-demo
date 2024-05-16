package com.example.demo.service;

import com.example.demo.repository.Product;
import com.example.demo.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAllByOrderByIdAsc();
    }

    public Product getProductById(Long id) {
        return productRepository.findProductById(id);
    }

    public void deleteProduct(Long id) {
         productRepository.deleteById(id);
    }
}
