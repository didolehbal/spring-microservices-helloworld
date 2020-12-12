package com.enset.jwtservice.controllers;

import java.util.List;

import com.enset.jwtservice.entities.User;
import com.enset.jwtservice.services.UsersService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {
    
    private UsersService usersService;

    UsersController(UsersService usersService){
        this.usersService = usersService;
    }

    @GetMapping(path = "/")
    public List<User> users(){
        return this.usersService.findAllUsers();
    }
    
}
