package com.live.butterfly;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ProfileController {

    @GetMapping("/profile/{username}")
    public Login getProfile(@PathVariable String username) {

        Login user = new Login();

        user.setUsername(username);
        user.setPassword("****"); // hide password

        return user;
    }
}