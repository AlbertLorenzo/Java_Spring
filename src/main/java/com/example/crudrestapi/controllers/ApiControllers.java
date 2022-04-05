package com.example.crudrestapi.controllers;

import com.example.crudrestapi.models.UserModel;
import com.example.crudrestapi.repos.UserRepo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ApiControllers {

    @Autowired
    private UserRepo userRepo;

    @GetMapping(value = "/")
    public String welcome() {
        return "Welcome!";
    }

    @GetMapping(value = "/users")
    public List<UserModel> getAllUsers() {
        return (List<UserModel>) userRepo.findAll();
    }

    @PostMapping(value = "/save")
    public String saveUser(@RequestBody UserModel user) {
        userRepo.save(user);
        return "User saved.";
    }

    @PutMapping(value = "/update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody UserModel user) {
        UserModel updatedUser = userRepo.findById(id).get();
        updatedUser.setName(user.getName());
        updatedUser.setLastname(user.getLastname());
        return "User updated.";
    }

    @PutMapping(value = "/delete/{id}")
    public String updateUser(@PathVariable long id) {
        UserModel deleteUser = userRepo.findById(id).get();
        userRepo.deleteById(id);
        return "User updated.";
    }

}
