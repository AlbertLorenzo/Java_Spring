package com.example.crudrestapi.services;

import com.example.crudrestapi.models.UserModel;
import com.example.crudrestapi.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public HashSet<UserModel> getAllUsers() {
        return (HashSet<UserModel>) userRepo.findAll();
    }

    public UserModel insertUser(UserModel user) {
        return userRepo.save(user);
    }
}
