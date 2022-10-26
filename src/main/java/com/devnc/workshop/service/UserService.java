package com.devnc.workshop.service;

import com.devnc.workshop.entities.User;
import com.devnc.workshop.repository.UserRepository;
import com.devnc.workshop.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findByid(String id){
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Error: ID não constado no sistema."));
    }


}
