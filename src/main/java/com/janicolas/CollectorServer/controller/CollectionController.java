package com.janicolas.CollectorServer.controller;

import com.janicolas.CollectorServer.entity.Collection;
import com.janicolas.CollectorServer.entity.CollectionId;
import com.janicolas.CollectorServer.service.CollectionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/collection")
public class CollectionController {

    private final CollectionService service;

    public CollectionController(CollectionService service){
        this.service = service;
    }

    @GetMapping("/user")
    public List<Collection> getCollectionByUserId(@RequestParam Long id){
        return service.findByUserId(id);
    }

    @GetMapping("/exists")
    public Boolean existsCollection(@RequestParam Long puzzleId, @RequestParam Long userId){
        return service.existsByPuzzleIdAndUserId(puzzleId,userId);
    }

    @PostMapping
    public Collection createCollection(@RequestParam Long userId, @RequestParam Long puzzleId,
                                       @RequestParam(value = "notes", required = false) String notes){
        return service.create(userId, puzzleId, notes);
    }

    @DeleteMapping("/delete")
    public Boolean deleteCollection(@RequestParam Long userId, @RequestParam Long puzzleId){
        CollectionId id = new CollectionId(userId, puzzleId);
        return service.delete(id);
    }
}
