package com.janicolas.CollectorServer.service;

import com.janicolas.CollectorServer.entity.MainEvent;
import com.janicolas.CollectorServer.repository.MainEventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MainEventService {

    private final MainEventRepository repository;

    public MainEventService(MainEventRepository repository){
        this.repository = repository;
    }

    public List<MainEvent> findAll(){return repository.findAll();}

    public Optional<MainEvent> findById(Long id){return repository.findById(id);}

    public MainEvent create(MainEvent mainEvent){return repository.save(mainEvent);}

    public MainEvent update(MainEvent mainEvent){return repository.save(mainEvent);}

    public boolean delete(Long id){
        if (repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
