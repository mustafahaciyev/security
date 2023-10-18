package com.example.security.controller;

import com.example.security.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/security")
public class UsersController {

    private final UsersService usersService;

    @GetMapping("/public")
    public String getPublic(){
        return "Hello public";
    }

    @PostMapping("/public")
    public String postPublic() {
        return "Hello public (POST)";
    }


    @PostMapping("/hello")
    public String getHello(){
        return "Hello hello";
    }

    @GetMapping("/user")
    public String getUser(){
        return "Hello public";
    }

    @GetMapping("/admin")
    public String getAdmin(){
        return "Hello public";
    }

}
