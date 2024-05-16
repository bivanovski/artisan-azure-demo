package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT bs FROM Product bs WHERE bs.id = ?1")
    Product findProductById(Long id);

    List<Product> findAllByOrderByIdAsc();

    Product findByIdAndArtisanId(Long productId, Long artisanId);
}
