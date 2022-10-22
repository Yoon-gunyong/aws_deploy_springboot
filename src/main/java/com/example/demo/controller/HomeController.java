package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //Controller를 통해서 리턴이 되는 것은 templates로 들어간다. 처음에는 Controller가서 templates로 , Controller에 없으면 static
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "home";

    }
}
