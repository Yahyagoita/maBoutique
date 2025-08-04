package com.farouk.farouk.service;

import com.farouk.farouk.model.Utilisateurs;
import com.farouk.farouk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<Utilisateurs> findAll(){
        return userRepository.findAll();
    }
    public Utilisateurs create(Utilisateurs utilisateurs){
        return userRepository.saveAndFlush(utilisateurs);
    }

}
