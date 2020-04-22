package com.vmp.server.controllers;

import com.vmp.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/admin")
    public String userList() {
        return ("Hi, admin");
    }


}