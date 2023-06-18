package com.janicolas.CollectorServer.repository;

import com.janicolas.CollectorServer.entity.Puzzle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PuzzleRepository extends JpaRepository<Puzzle, Long> {
    List<Puzzle> findByName(String name);
    List<Puzzle> findByPriceBetween(Double priceMin, Double priceMax);
    List<Puzzle> findByBrand(String brand);
    List<Puzzle> findByType(int type);
}