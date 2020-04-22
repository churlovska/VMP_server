package com.vmp.server.service;

import com.vmp.server.entities.CityEntity;
import com.vmp.server.repositories.CityRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    @Autowired
    CityRep cityRep;

    public CityEntity createCity(CityEntity city) {
        cityRep.save(city);
        return city;
    }

}
