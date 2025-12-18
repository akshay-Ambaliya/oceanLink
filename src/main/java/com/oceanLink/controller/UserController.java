package com.oceanLink.controller;

import com.oceanLink.dto.UserDTO;
import com.oceanLink.model.User;
import com.oceanLink.service.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("/user")
    public User createUser(@RequestBody User user){
        return service.createUser(user);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> findAllUsers(){
        List<UserDTO>  dtos = service.findAllUser();

        if(dtos.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDTO> findUSerById(@PathVariable int id){
        Optional<UserDTO> dto= service.findUserById(id);

        if(dto.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(dto.get());
    }
}
