package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    public UserRepository userRepository;

 public void saveOrUpdate(User user){
     userRepository.save(user);
 }

 public List<User> getAll(){
     return userRepository.findAll();
    }
}
