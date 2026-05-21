package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User u){
    User savedUser = userService.saveOrUpdate(u);
    return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<User>> getAll(){
    List<User> list = userService.getAll();
    return ResponseEntity.ok(list);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getById(@PathVariable long id){
        User user = userService.getById(id).orElseThrow(() ->
                new RuntimeException("User Not Found!"));
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(
            @PathVariable Long id) {

        userService.delete(id);

        return ResponseEntity.ok(
                "User Deleted Successfully"
        );
    }
    @PutMapping("{id}")
    public ResponseEntity<User> update(
            @PathVariable long id,
            @RequestBody User user){

        user.setId(id);
        User updatedUser = userService.saveOrUpdate(user);

        return ResponseEntity.ok(updatedUser);
    }
}
