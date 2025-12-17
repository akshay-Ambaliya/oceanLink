package com.oceanLink.controller;

import com.oceanLink.model.User;
import com.oceanLink.service.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    UserService u;

    @PostMapping("/user")
    public User createUser(User user){
        return u.createUser(user);
    }
}
