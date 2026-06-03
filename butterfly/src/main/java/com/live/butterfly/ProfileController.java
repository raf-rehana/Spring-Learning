package com.live.butterfly;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ProfileController {

    public record UserProfile(String firstName, String lastName, String email, String phone) {
    }

    @GetMapping("profile/{username}")
    public UserProfile getProfile(@PathVariable String username) {
        if ("rafiaah".equals(username)) {
            return new UserProfile("Rafiaah", "Rehana", "rafiaah", "+123456789");
        }
        return new UserProfile(username, "", username + "@gmail.com", "+000000000");
    }
}