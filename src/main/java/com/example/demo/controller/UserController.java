package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.payload.Result;
import com.example.demo.servise.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    //CREATE
    @GetMapping
    public Result addUser(@RequestBody User user){
       return userService.addUser(user);
    }
    //READ
    //DELETE
    //UPDATE
    //READ BY ID

}
