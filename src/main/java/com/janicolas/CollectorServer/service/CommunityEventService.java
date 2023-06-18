package com.janicolas.CollectorServer.service;

import com.janicolas.CollectorServer.entity.CommunityEvent;
import com.janicolas.CollectorServer.repository.CommunityEventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommunityEventService {

    private final CommunityEventRepository repository;

    public CommunityEventService(CommunityEventRepository repository){
        this.repository = repository;
    }

    public List<CommunityEvent> findAll(){return repository.findAll();}

    public Optional<CommunityEvent> findById(Long id){return repository.findById(id);}

    public CommunityEvent create(CommunityEvent communityEvent){return repository.save(communityEvent);}

    public CommunityEvent update(CommunityEvent communityEvent){return repository.save(communityEvent);}

    public boolean delete(Long id){
        if (repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
