package com.janicolas.CollectorServer.service;

import com.janicolas.CollectorServer.entity.Puzzle;
import com.janicolas.CollectorServer.repository.PuzzleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PuzzleService {

    private final PuzzleRepository repository;

    public PuzzleService(PuzzleRepository repository){
        this.repository = repository;
    }

    public List<Puzzle> findAll(){return repository.findAll();}

    public Optional<Puzzle> findById(Long id){return repository.findById(id);}

    public List<Puzzle> findByName(String name){return repository.findByName(name);}

    public List<Puzzle> findByPrice(Double priceMin, Double priceMax){
        return repository.findByPriceBetween(priceMin, priceMax);
    }

    public List<Puzzle> findByBrand(String brand){return repository.findByBrand(brand);}

    public List<Puzzle> findByType(int type){return repository.findByType(type);}

    public Puzzle create(Puzzle puzzle){
        return repository.save(puzzle);
    }

    public Puzzle update(Puzzle puzzle){
        return repository.save(puzzle);
    }

    public boolean delete(Long id){
        if (repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
