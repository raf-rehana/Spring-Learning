package com.live.butterfly;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "http://localhost:4200")
public class RegistrationController {

    @PostMapping("registration")
    public RedirectView register(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String phone,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String confirmPassword) {

        // Save the user in LoginController's static map so they can log in!
        LoginController.users.put(email, password);
        
        System.out.println("Registered new user: " + email);

        // Redirecting back to Angular's login page after successful registration
        return new RedirectView("http://localhost:4200/login");
    }
}
