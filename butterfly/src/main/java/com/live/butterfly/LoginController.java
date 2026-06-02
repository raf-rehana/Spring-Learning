package com.live.butterfly;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

    @PostMapping("/login")
    public String loginRequest(@RequestBody Login login) {

        if ("rafiaah".equals(login.getUsername())
                && "4321ra".equals(login.getPassword())) {
            return "success";
        }

        return "failed";
    }

}
