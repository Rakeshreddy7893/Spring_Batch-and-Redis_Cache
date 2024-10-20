package com.recykal.Specifications.controller;

import com.recykal.Specifications.entity.User;
import com.recykal.Specifications.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/user")
    public User saveUser(@RequestBody User user){
        return  userService.saveUser(user);
    }

    @GetMapping("/users")
    public List<User> searchUser(@RequestParam(required = false) String name,@RequestParam(required = false) String email,@RequestParam(required = false) String role){
        return userService.searchUser(name,email,role);
    }

}
