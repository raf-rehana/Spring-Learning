package com.example.demo.controller;

import com.example.demo.util.EmailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public String sendEmail(@RequestBody String toEmail) throws MessagingException {

        emailService.sendSimpleMail(
                toEmail,
                "Test Mail",
                "Hello from Spring Boot"
        );

        return "Email sent successfully";
    }
}
