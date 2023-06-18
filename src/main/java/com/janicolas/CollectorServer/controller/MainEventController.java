package com.janicolas.CollectorServer.controller;

import com.janicolas.CollectorServer.entity.MainEvent;
import com.janicolas.CollectorServer.service.MainEventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mainevent")
public class MainEventController {

    private final MainEventService service;

    public MainEventController(MainEventService service){
        this.service = service;
    }

    @GetMapping("/all")
    public List<MainEvent> getMainEvents(){
        return service.findAll();
    }

    @GetMapping
    public Optional<MainEvent> getMainEvent(@RequestParam Long id){
        return service.findById(id);
    }

    @PostMapping
    public MainEvent newMainEvent(@RequestBody MainEvent mainEvent){
        return service.create(mainEvent);
    }

    @PutMapping
    public MainEvent updateMainEvent(@RequestBody MainEvent mainEvent){
        return service.update(mainEvent);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteMainEvent(@PathVariable(name = "id") Long id){
        return service.delete(id);
    }
}
