package com.janicolas.CollectorServer.service;

import com.janicolas.CollectorServer.entity.Collection;
import com.janicolas.CollectorServer.entity.CollectionId;
import com.janicolas.CollectorServer.entity.Puzzle;
import com.janicolas.CollectorServer.entity.User;
import com.janicolas.CollectorServer.repository.CollectionRepository;
import com.janicolas.CollectorServer.repository.PuzzleRepository;
import com.janicolas.CollectorServer.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.sql.Time;
import java.util.List;

@Service
public class CollectionService {

    private final CollectionRepository repository;
    private final UserRepository userRepository;
    private final PuzzleRepository puzzleRepository;

    public CollectionService(CollectionRepository repository, UserRepository userRepository,
                             PuzzleRepository puzzleRepository){
        this.repository = repository;
        this.userRepository = userRepository;
        this.puzzleRepository = puzzleRepository;
    }

    public List<Collection> findByUserId(Long id){
        return repository.findByUserId(id);
    }

    public Boolean existsByPuzzleIdAndUserId(Long puzzle_id, Long user_id){
        return repository.existsByPuzzleIdAndUserId(puzzle_id,user_id);
    }

    public Collection create(Long userId, Long puzzleId, Time best){
        Collection collection = new Collection();

        User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User not found"));
        Puzzle puzzle = puzzleRepository.findById(puzzleId).orElseThrow(() -> new NotFoundException("Puzzle not found"));

        collection.setId(new CollectionId(userId, puzzleId));
        collection.setUser(user);
        collection.setPuzzle(puzzle);
        collection.setBest(best);

        return repository.save(collection);
    }

    public Boolean delete(CollectionId id){
        if (repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
