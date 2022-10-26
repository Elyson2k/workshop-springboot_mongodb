package com.devnc.workshop.controller;

import com.devnc.workshop.dto.UserDTO;
import com.devnc.workshop.entities.User;
import com.devnc.workshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        User user = service.findByid(id);
        UserDTO newObj = new UserDTO(user);
        return ResponseEntity.ok().body(newObj);
    }
}
