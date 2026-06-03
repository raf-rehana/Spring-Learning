package com.live.butterfly;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

    @PostMapping("login")
    public String loginRequest(@RequestParam String username, @RequestParam String password) {

        if ("rafiaah".equals(username)
                && "4321ra".equals(password)) {
            return "success";
        }

        return "failed";
    }

}
