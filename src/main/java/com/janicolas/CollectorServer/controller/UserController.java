package com.janicolas.CollectorServer.controller;

import com.janicolas.CollectorServer.entity.User;
import com.janicolas.CollectorServer.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    public UserController(UserService service){
        this.service = service;
    }

    @GetMapping("/all")
    public List<User> getUsers(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping("/username={username}")
    public Optional<User> getUserByUsername(@PathVariable String username){
        return service.findByUsername(username);
    }

    @GetMapping("/exists")
    public Boolean existsUserByUsername(@RequestParam String username){
        return service.existsUserByUsername(username);
    }

    @PostMapping
    public User newUser(@RequestBody User user){
        return service.create(user);
    }

    @PutMapping
    public User updateUser(@RequestBody User user){
        return service.update(user);
    }

    @DeleteMapping("/delete")
    public Boolean deleteUser(@RequestParam Long id){
        return service.delete(id);
    }
}
