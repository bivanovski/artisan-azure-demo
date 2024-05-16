package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArtisanRepository extends JpaRepository<Artisan, Long> {
    @Query("SELECT bs FROM Artisan bs WHERE bs.id = ?1")
    Artisan findArtisanById(Long id);

    List<Artisan> findAllByOrderByIdAsc();
}
