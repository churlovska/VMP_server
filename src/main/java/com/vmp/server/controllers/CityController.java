package com.vmp.server.controllers;

import com.vmp.server.entities.CityEntity;
import com.vmp.server.repositories.CityRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CityController {

    @Autowired
    CityRep cityRep;

    @GetMapping("/cities")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<CityEntity> selectCities() {
        return cityRep.findAllByOrderByCityAsc();
    }

    @PostMapping(path = "/city")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public void addCity(@RequestBody CityEntity cityEntity) {
        if (cityEntity != null) {
            cityRep.save(cityEntity);
        }
    }

    @PutMapping("/city/{id}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public void updateCity(@RequestBody CityEntity cityEntity, @PathVariable Integer id) {
        cityEntity.setId(id);
        cityRep.save(cityEntity);
    }

    @DeleteMapping("/city/{id}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public void deleteCity(@PathVariable Integer id) {

        try {
            if (cityRep.existsById(id)) {
                cityRep.deleteById(id);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
