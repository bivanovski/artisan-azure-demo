package com.example.demo.service;

import com.example.demo.repository.Artisan;
import com.example.demo.repository.ArtisanRepository;
import com.example.demo.repository.Product;
import com.example.demo.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ArtisanService {
    @Autowired
    ArtisanRepository artisanRepository;

    @Autowired
    ProductRepository productRepository;


    public List<Artisan> getAllArtisans() {
        return artisanRepository.findAllByOrderByIdAsc();
    }

    public Artisan createArtisan(Artisan artisan) {
        return artisanRepository.save(artisan);
    }

    public Artisan updateArtisan(Artisan artisan) {
        return artisanRepository.save(artisan);
    }

    public void deleteArtisan(Long id) {
        artisanRepository.deleteById(id);
    }

    public Artisan getArtisanById(Long id) {
        return artisanRepository.findArtisanById(id);
    }

    public Product addProductToArtisan(Long artisanId, Product product) {

        Artisan artisan = artisanRepository.findById(artisanId)
                .orElseThrow(() -> new IllegalArgumentException("Artisan not found"));

        product.setArtisan(artisan);

        return productRepository.save(product);

    }

    public Product updateProductOfArtisan(Long artisanId, Long productId, Product updatedProduct) {
        Artisan artisan = artisanRepository.findById(artisanId)
                .orElseThrow(() -> new IllegalArgumentException("Artisan not found"));

        Product product = productRepository.findById(productId).orElseThrow(() -> new IllegalArgumentException("Product not found"));

        product.setArtisan(artisan);

        product.setName(updatedProduct.getName());
        product.setCategory(updatedProduct.getCategory());
        product.setPrice(updatedProduct.getPrice());
        product.setWeight(updatedProduct.getWeight());

        return productRepository.save(product);
    }
}
