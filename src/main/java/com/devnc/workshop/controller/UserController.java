package com.devnc.workshop.controller;

import com.devnc.workshop.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController {

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok().body();
    }
}
