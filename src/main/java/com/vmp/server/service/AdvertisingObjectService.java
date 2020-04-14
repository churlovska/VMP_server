package com.vmp.server.service;

import com.vmp.server.entities.AdvertisingObjectEntity;
import com.vmp.server.repositories.AdvertisingObjectRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;

@Service
public class AdvertisingObjectService {

    @Autowired
    AdvertisingObjectRep advertisingObjectRep;

    @PersistenceContext
    EntityManager entityManager;

    public AdvertisingObjectEntity createAO(AdvertisingObjectEntity newAO) {

        try {
            advertisingObjectRep.save(newAO);
            //insertWithEntityManager(newAO);
            return newAO;
        }
        catch(PersistenceException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Transactional
    public void insertWithEntityManager(AdvertisingObjectEntity advertisingObjectEntity) {
        this.entityManager.persist(advertisingObjectEntity);
    }

}
