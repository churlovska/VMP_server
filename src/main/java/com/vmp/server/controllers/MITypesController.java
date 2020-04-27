package com.vmp.server.controllers;

import com.vmp.server.entities.MiTypesEntity;
import com.vmp.server.repositories.AOTypesRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MITypesController {

    @Autowired
    AOTypesRep aoTypesRep;

    @GetMapping("/types")
    public List<MiTypesEntity> selectAOTypes() {
        return aoTypesRep.findAllByOrderByType();
    }
}
