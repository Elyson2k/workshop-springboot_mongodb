package com.devnc.workshop.controller;

import com.devnc.workshop.dto.UserDTO;
import com.devnc.workshop.entities.Post;
import com.devnc.workshop.entities.User;
import com.devnc.workshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> user = service.findAll();
        List<UserDTO> listDto = user.stream().map(obj -> new UserDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> find(@PathVariable String id){
        User user = service.findByID(id);
        UserDTO newObj = new UserDTO(user);
        return ResponseEntity.ok().body(newObj);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDTO userDTO){
        User obj = service.fromDTO(userDTO);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> insert(@PathVariable String id){
        service.deleteUserID(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> insert(@PathVariable String id, @RequestBody UserDTO userDTO){
        service.update(id,userDTO);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}/posts")
    public ResponseEntity<List<Post>> findPosts(@PathVariable String id){
        User user = service.findByID(id);
        return ResponseEntity.ok().body(user.getPosts());
    }


}
