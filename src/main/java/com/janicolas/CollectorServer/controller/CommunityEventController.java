package com.janicolas.CollectorServer.controller;

import com.janicolas.CollectorServer.entity.CommunityEvent;
import com.janicolas.CollectorServer.service.CommunityEventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/communityevent")
public class CommunityEventController {

    private final CommunityEventService service;

    public CommunityEventController(CommunityEventService service){
        this.service = service;
    }

    @GetMapping("/all")
    public List<CommunityEvent> getCommunityEvents(){
        return service.findAll();
    }

    @GetMapping
    public Optional<CommunityEvent> getCommunityEvent(@RequestParam Long id){
        return service.findById(id);
    }

    @PostMapping
    public CommunityEvent newCommunityEvent (@RequestBody CommunityEvent communityEvent){
        return service.create(communityEvent);
    }

    @PutMapping
    public CommunityEvent updateCommunityEvent(@RequestBody CommunityEvent communityEvent){
        return service.update(communityEvent);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteMainEvent(@PathVariable(name = "id") Long id){
        return service.delete(id);
    }
}
