package com.vmp.server.service;

import com.vmp.server.entities.AdvertisingObjectEntity;
import com.vmp.server.entities.CityEntity;
import com.vmp.server.repositories.CityRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;

@Service
public class CityService {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    CityRep cityRep;

    public CityEntity createCity(CityEntity city) {

        try {
            cityRep.save(city);
       //     insertCity(city);
            return city;
        }
        catch(PersistenceException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Transactional
    public void insertCity(CityEntity city) {
        this.entityManager.persist(city);
    }

}
