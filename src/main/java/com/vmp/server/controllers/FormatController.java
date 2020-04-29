package com.vmp.server.controllers;

import com.vmp.server.entities.FormatsEntity;
import com.vmp.server.repositories.FormatsRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FormatController {

    @Autowired
    FormatsRep formatsRep;

    @GetMapping("/formats")
    public List<FormatsEntity> selectFormats() {
        return formatsRep.findAllByOrderByFormat();
    }

    @PostMapping("/formats")
    public void addFormat(@RequestBody FormatsEntity formatsEntity) {
        formatsRep.save(formatsEntity);
    }

    @PutMapping("/formats/{id}")
    public void updateFormat(@RequestBody FormatsEntity formatsEntity, @PathVariable Integer id) {
        formatsEntity.setId(id);
        formatsRep.save(formatsEntity);
    }

    @DeleteMapping("/formats/{id}")
    public void deleteFormat(@PathVariable Integer id) {

        try {
            if (formatsRep.existsById(id)) {
                formatsRep.deleteById(id);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
