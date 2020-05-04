package com.vmp.server.controllers;

import com.vmp.server.entities.CityEntity;
import com.vmp.server.entities.MiSocSignEntity;
import com.vmp.server.repositories.MiSocSignRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MISocSignController {

    @Autowired
    MiSocSignRep miSocSignRep;

    @GetMapping("/significance")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<MiSocSignEntity> selectSignificance() {
        return miSocSignRep.findAllByOrderBySignificance();
    }

    @PostMapping(path = "/significance")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public void addSignificance(@RequestBody MiSocSignEntity miSocSignEntity) {
        if (miSocSignEntity != null) {
            miSocSignRep.save(miSocSignEntity);
        }
    }

    @PutMapping("/significance/{id}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public void updateSignificance(@RequestBody MiSocSignEntity miSocSignEntity, @PathVariable Integer id) {
        miSocSignEntity.setId(id);
        miSocSignRep.save(miSocSignEntity);
    }

    @DeleteMapping("/significance/{id}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public void deleteSignificance(@PathVariable Integer id) {

        try {
            if (miSocSignRep.existsById(id)) {
                miSocSignRep.deleteById(id);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
