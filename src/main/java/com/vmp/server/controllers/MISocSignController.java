package com.vmp.server.controllers;

import com.vmp.server.entities.MiSocSignEntity;
import com.vmp.server.repositories.MiSocSignRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MISocSignController {

    @Autowired
    MiSocSignRep miSocSignRep;

    @GetMapping("/significance")
    public List<MiSocSignEntity> selectSignificance() {
        return miSocSignRep.findAllByOrderBySignificance();
    }
}
