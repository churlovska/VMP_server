package com.vmp.server.controllers;

import com.vmp.server.entities.*;
import com.vmp.server.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class VMPUserController {

    @Autowired
    VMPUserRep vmpUserRep;

    @GetMapping("/users")
    public List<VMPUserEntity> selectUsers() {
        return vmpUserRep.findByOrderByLastnameAscFirstnameAscLoginAsc();
    }
}
