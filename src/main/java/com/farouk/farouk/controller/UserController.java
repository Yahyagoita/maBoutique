package com.farouk.farouk.controller;

import com.farouk.farouk.model.Utilisateurs;
import com.farouk.farouk.repository.UserRepository;
import com.farouk.farouk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/farouk")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/listeUsers")
    public List<Utilisateurs> findAll(){
        return userService.findAll();
    }
    @PostMapping("/saveUser")
    public Utilisateurs create(Utilisateurs utilisateurs){
        return userService.create(utilisateurs);
    }
}
