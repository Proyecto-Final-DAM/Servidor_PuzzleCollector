package com.janicolas.CollectorServer.service;

import com.janicolas.CollectorServer.entity.User;
import com.janicolas.CollectorServer.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository){
        this.repository = repository;
    }

    public List<User> findAll() {return repository.findAll();}

    public Optional<User> findById(Long id) {
        return repository.findById(id);
    }

    public Optional<User> findByUsername(String username) {
        return repository.findByUsername(username);
    }

    public Boolean existsUserByUsername(String username){
        return repository.existsUserByUsername(username);
    }

    public User create(User user){
        return repository.save(user);
    }

    public User update(User user){
        return repository.save(user);
    }

    public Boolean delete(Long id){
        if (repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}