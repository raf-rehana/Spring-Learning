package com.live.butterfly;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

    // Store all registered users (email -> password)
    public static Map<String, String> users = new HashMap<>();

    static {
        // Keep the original test user!
        users.put("rafiaah", "4321ra");
    }

    @PostMapping("login")
    public String loginRequest(@RequestBody Login login) {

        // Check if the user exists and the password matches!
        if (users.containsKey(username) && users.get(username).equals(password)) {
            return "success";
        }

        return "failed";
    }

}
