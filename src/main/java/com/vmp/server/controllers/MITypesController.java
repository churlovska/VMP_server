package com.vmp.server.controllers;

import com.vmp.server.entities.MiSocSignEntity;
import com.vmp.server.entities.MiTypesEntity;
import com.vmp.server.repositories.AOTypesRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MITypesController {

    @Autowired
    AOTypesRep aoTypesRep;

    @GetMapping("/types")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<MiTypesEntity> selectAOTypes() {
        return aoTypesRep.findAllByOrderByType();
    }

    @PostMapping(path = "/types")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public void addAOTypes(@RequestBody MiTypesEntity miTypesEntity) {
        if (miTypesEntity != null) {
            aoTypesRep.save(miTypesEntity);
        }
    }

    @PutMapping("/types/{id}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public void updateAOTypes(@RequestBody MiTypesEntity miTypesEntity, @PathVariable Integer id) {
        miTypesEntity.setId(id);
        aoTypesRep.save(miTypesEntity);
    }

    @DeleteMapping("/types/{id}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public void deleteAOTypes(@PathVariable Integer id) {

        try {
            if (aoTypesRep.existsById(id)) {
                aoTypesRep.deleteById(id);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
