package com.example.demo.controller;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getById(@PathVariable Integer id) {
        User user = userService.getById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return ResponseEntity.ok(user);
    }

    @PutMapping("{id}")
    public ResponseEntity<User> update(
            @PathVariable Integer id,
            @RequestBody User user) {
        user.setId(id);
        return ResponseEntity.ok(userService.save(user));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        userService.delete(id);
        return ResponseEntity.ok("User Deleted Successfully");
    }

    @GetMapping("country/{id}")
    public ResponseEntity<List<UserDTO>> getByCountry(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.getUsersByCountryId(id));
    }

    @GetMapping("division/{id}")
    public ResponseEntity<List<UserDTO>> getByDivision(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.getUsersByDivisionId(id));
    }

    @GetMapping("district/{id}")
    public ResponseEntity<List<UserDTO>> getByDistrict(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.getUsersByDistrictId(id));
    }

    @GetMapping("department/{id}")
    public ResponseEntity<List<UserDTO>> getByDepartment(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.getUsersByDepartmentId(id));
    }
}
