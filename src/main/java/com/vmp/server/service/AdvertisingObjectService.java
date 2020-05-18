package com.vmp.server.service;

import com.vmp.server.entities.AdvertisingObjectEntity;
import com.vmp.server.repositories.*;
import com.vmp.server.response.AOResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;

@Service
public class AdvertisingObjectService {

    @Autowired
    AdvertisingObjectRep advertisingObjectRep;
    @Autowired
    CityRep cityRep;
    @Autowired
    MiSocSignRep miSocSignRep;
    @Autowired
    SegmentsRep segmentsRep;
    @Autowired
    FormatsRep formatsRep;
    @Autowired
    AOTypesRep aoTypesRep;

    @Transactional
    public boolean createAO(int id, AOResponse newAO) {

        AdvertisingObjectEntity advertisingObjectEntity = new AdvertisingObjectEntity(
                newAO.getName(), newAO.getAddress(), newAO.getReservation_status(), newAO.getFloor(),
                newAO.getNeighbors(), newAO.getPlace_description(), newAO.getSpecialist_description(),
                newAO.getContract(), newAO.getPrice(), newAO.getDate_from(), newAO.getDate_to(),
                newAO.getComments(), newAO.getPockets(), newAO.getPossibility_of_placement(),
                newAO.getClient(), newAO.getPhoto());

        advertisingObjectEntity.setCity(cityRep.getOne(newAO.getCity_id()));
        advertisingObjectEntity.setMi(miSocSignRep.getOne(newAO.getMi_id()));
        advertisingObjectEntity.setSegment(segmentsRep.getOne(newAO.getSegment_id()));
        if (newAO.getSubsegment1_id() != null) {
            advertisingObjectEntity.setSubsegment1(segmentsRep.getOne(newAO.getSubsegment1_id()));
        }
        if (newAO.getSubsegment2_id() != null) {
            advertisingObjectEntity.setSubsegment2(segmentsRep.getOne(newAO.getSubsegment2_id()));
        }
        if (newAO.getSubsegment3_id() != null) {
            advertisingObjectEntity.setSubsegment3(segmentsRep.getOne(newAO.getSubsegment3_id()));
        }
        advertisingObjectEntity.setPlacing_format(formatsRep.getOne(newAO.getPlacing_format_id()));
        advertisingObjectEntity.setMi_type(aoTypesRep.getOne(newAO.getMi_type_id()));

        if (id != -1) {
            advertisingObjectEntity.setId(id);
        }

        try {
            advertisingObjectRep.save(advertisingObjectEntity);
            return true;
        }
        catch(Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Transactional
    public boolean createAOPhoto(int id, AOResponse newAO, MultipartFile file) {

        AdvertisingObjectEntity advertisingObjectEntity = new AdvertisingObjectEntity(
                newAO.getName(), newAO.getAddress(), newAO.getReservation_status(), newAO.getFloor(),
                newAO.getNeighbors(), newAO.getPlace_description(), newAO.getSpecialist_description(),
                newAO.getContract(), newAO.getPrice(), newAO.getDate_from(), newAO.getDate_to(),
                newAO.getComments(), newAO.getPockets(), newAO.getPossibility_of_placement(),
                newAO.getClient(), newAO.getPhoto());

        advertisingObjectEntity.setCity(cityRep.getOne(newAO.getCity_id()));
        advertisingObjectEntity.setMi(miSocSignRep.getOne(newAO.getMi_id()));
        advertisingObjectEntity.setSegment(segmentsRep.getOne(newAO.getSegment_id()));
        advertisingObjectEntity.setSubsegment1(segmentsRep.getOne(newAO.getSubsegment1_id()));
        advertisingObjectEntity.setSubsegment2(segmentsRep.getOne(newAO.getSubsegment2_id()));
        advertisingObjectEntity.setSubsegment3(segmentsRep.getOne(newAO.getSubsegment3_id()));
        advertisingObjectEntity.setPlacing_format(formatsRep.getOne(newAO.getPlacing_format_id()));
        advertisingObjectEntity.setMi_type(aoTypesRep.getOne(newAO.getMi_type_id()));

        try {
            advertisingObjectEntity.setPhoto(file.getBytes());
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        if (id != -1) {
            advertisingObjectEntity.setId(id);
        }

        try {
            advertisingObjectRep.save(advertisingObjectEntity);
            return true;
        }
        catch(Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public Boolean deleteAO (Integer id) {
        try {
            if (advertisingObjectRep.existsById(id)) {
                advertisingObjectRep.deleteById(id);
                return true;
            }
            return false;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }
}
