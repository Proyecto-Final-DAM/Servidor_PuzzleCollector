package com.janicolas.CollectorServer.controller;

import com.janicolas.CollectorServer.entity.Puzzle;
import com.janicolas.CollectorServer.service.PuzzleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/puzzle")
public class PuzzleController {

    private final PuzzleService service;

    public PuzzleController(PuzzleService service){
        this.service = service;
    }

    @GetMapping("/all")
    public List<Puzzle> getPuzzles(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    //@Operation(summary = "Get a Puzzle info from its ID")
    public Optional<Puzzle> getPuzzleById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping("/price")
    //@ApiOperation(value = "Find Puzzles by price but setting a minPrice and a maxPrice")
    public List<Puzzle> getPuzzlesByPrice(@RequestParam Double priceMin, @RequestParam Double priceMax){
        return service.findByPrice(priceMin, priceMax);
    }

    @GetMapping("/brand={brand}")
    public List<Puzzle> getPuzzleByBrand(@PathVariable String brand){
        return service.findByBrand(brand);
    }

    @GetMapping("/type={type}")
    public List<Puzzle> getPuzzlesByType(@PathVariable int type){
        return service.findByType(type);
    }

    @PostMapping
    public Puzzle newPuzzle(@RequestBody Puzzle puzzle){
        return service.create(puzzle);
    }

    @PutMapping
    public Puzzle updatePuzzle(@RequestBody Puzzle puzzle){
        return service.update(puzzle);
    }

    @DeleteMapping("/delete")
    public boolean deletePuzzle(@RequestParam Long id){
        return service.delete(id);
    }
}
