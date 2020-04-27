package com.vmp.server.controllers;

import com.vmp.server.entities.FormatsEntity;
import com.vmp.server.repositories.FormatsRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FormatController {

    @Autowired
    FormatsRep formatsRep;

    @GetMapping("/formats")
    public List<FormatsEntity> selectFormats() {
        return formatsRep.findAllByOrderByFormat();
    }
}
