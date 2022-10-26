package com.devnc.workshop.service;

import com.devnc.workshop.entities.Post;
import com.devnc.workshop.repository.PostRepository;
import com.devnc.workshop.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository userRepository;

    public Post findByID(String id){
        Optional<Post> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Error: ID não constado no sistema."));
    }


}
