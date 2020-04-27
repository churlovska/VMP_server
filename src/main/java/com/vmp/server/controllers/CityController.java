package com.vmp.server.controllers;

import com.vmp.server.entities.CityEntity;
import com.vmp.server.repositories.CityRep;
import com.vmp.server.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CityController {

    @Autowired
    CityRep cityRep;

    @Autowired
    CityService cityService;

    @GetMapping("/cities")
    public List<CityEntity> selectCities() {
        return cityRep.findAllByOrderByCityAsc();
    }

    @PostMapping(path = "/city")
    public void addCity(@RequestBody CityEntity cityEntity) {
        if (cityEntity != null) {
            cityService.createCity(cityEntity);
        }
    }
}
