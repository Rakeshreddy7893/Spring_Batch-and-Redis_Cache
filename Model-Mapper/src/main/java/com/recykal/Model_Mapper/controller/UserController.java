package com.recykal.Model_Mapper.controller;

import com.recykal.Model_Mapper.dto.UserDTO;
import com.recykal.Model_Mapper.entity.User;
import com.recykal.Model_Mapper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping("/Register")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
        User user = userService.convertToEntity(userDTO);
        UserDTO createdUser = userService.convertToDTO(user);
        return ResponseEntity.ok(createdUser);
    }
}
