package com.live.practice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyPage {

    @GetMapping("/")
    public String home() {
        return "index";
    }
}
