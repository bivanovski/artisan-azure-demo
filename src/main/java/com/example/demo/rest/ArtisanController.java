package com.example.demo.rest;

import com.example.demo.repository.Artisan;
import com.example.demo.repository.Product;
import com.example.demo.service.ArtisanService;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artisan")
public class ArtisanController {

    @Autowired
    ArtisanService artisanService;

    @Autowired
    ProductService productService;

    //Get all artisans
    @GetMapping
    List<Artisan> getArtisans() {
        return artisanService.getAllArtisans();
    }

    //Get an artisan by its id
    @GetMapping("/{id}")
    Artisan getArtisanById(@PathVariable Long id) {
        return artisanService.getArtisanById(id);
    }

    //Register a new artisan
    @PostMapping
    Artisan registerArtisan(@RequestBody Artisan artisan) {
        return artisanService.createArtisan(artisan);
    }

    //Create a product and add it to an artisan
    @PostMapping("/{artisanId}/add-product")
    Product addProductToArtisan(@PathVariable Long artisanId, @RequestBody Product product) {
        return artisanService.addProductToArtisan(artisanId, product);
    }

   //Update the profile of the artisan
    @PutMapping
    Artisan updateArtisan(@RequestBody Artisan artisan) {
        return artisanService.updateArtisan(artisan);
    }

    @PutMapping("update-product/{productId}/{artisanId}")
    public Product updateProductOfArtisan(
            @PathVariable Long artisanId,
            @PathVariable Long productId,
            @RequestBody Product updatedProduct) {
        return artisanService.updateProductOfArtisan(artisanId, productId, updatedProduct);
    }

    //Delete an artisan by id
    @DeleteMapping("/{id}")
    void deleteArtisan(@PathVariable Long id) {
        artisanService.deleteArtisan(id);
    }
}
