package com.library.library_api.controller;


import com.library.library_api.model.entity.UserEntity;
import com.library.library_api.model.response.UserResponse;
import com.library.library_api.repository.UserRepository;
import com.library.library_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;




    @GetMapping
    public List<UserResponse> getUsers(){
        return userService.getUsers();
    }

    @PostMapping
    public ResponseEntity<UserEntity> postUser(@RequestBody UserEntity user){
        return new ResponseEntity<>(userRepository.save(user), HttpStatus.OK);
    }

}
