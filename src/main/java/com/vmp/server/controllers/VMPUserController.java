package com.vmp.server.controllers;

import com.vmp.server.entities.VMPUserEntity;
import com.vmp.server.repositories.VMPUserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class VMPUserController {

    @Autowired
    VMPUserRep vmpUserRep;

    @GetMapping("/")
    public String home(){
        return("Home page");
    }

    @GetMapping("/user")
    public List<VMPUserEntity> greeting() {
        return vmpUserRep.findAll();
    }
}
