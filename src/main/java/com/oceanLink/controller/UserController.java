package com.oceanLink.controller;

import com.oceanLink.dto.user.UserDTO;
import com.oceanLink.model.User;
import com.oceanLink.service.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<UserDTO> findUSerById(@PathVariable long id){
        Optional<UserDTO> dto= service.findUserById(id);

        if(dto.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto.get());
    }


    @PutMapping("/users/{id}")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO user,@PathVariable long id){
        Optional<UserDTO> dto= service.updateUser(user,id);

        if(dto.isPresent())
            return ResponseEntity.ok(dto.get());

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable int id){
        return (service.deleteUser(id))
                ?ResponseEntity.noContent().build() // 204 :: Approach Worked But nothing to Display
                :ResponseEntity.notFound().build(); // 404 :: Not Found
    }
}
