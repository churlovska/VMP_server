package com.vmp.server.controllers;

import com.vmp.server.entities.*;
import com.vmp.server.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@RestController
public class VMPUserController {

//    EntityManagerFactory emf = Persistence.createEntityManagerFactory(
//            "jdbc:postgresql://localhost:5432/VMP;user=postgres;password=postgres");

//    EntityManager em = emf.createEntityManager();

    @Autowired
    VMPUserRep vmpUserRep;

    @Autowired
    AdvertisingObjectRep advertisingObjectRep;

    @Autowired
    AOTypesRep aoTypesRep;

    @Autowired
    CityRep cityRep;

    @Autowired
    SegmentsRep segmentsRep;

    @Autowired
    FormatsRep formatsRep;

    @GetMapping("/")
    public String home(){
        return("Home page");
    }

    @GetMapping("/user")
    public List<VMPUserEntity> greeting() {
        return vmpUserRep.findAll();
    }

    @GetMapping("/ao_list_types")
    public List<AOTypesEntity> selectAOTypes() {
        return aoTypesRep.findAll();
    }

    @GetMapping("/ao_list_cities")
    public List<CityEntity> selectCities() {
        return cityRep.findAll();
    }

    @GetMapping("/ao_list_segments")
    public List<SegmentsEntity> selectSegments() {
        return segmentsRep.findAll();
    }

    @GetMapping("/ao_list_formats")
    public List<FormatsEntity> selectFormats() {
        return formatsRep.findAll();
    }

    @GetMapping("/ao_list_result")
    public List<AdvertisingObjectEntity> selectAO(@Param(value = "aoTypeId") String aoTypeId,
                                                  @Param(value = "cityId") String cityId,
                                                  @Param(value = "reservation") String reservation,
                                                  @Param(value = "segmentId") String segmentId,
                                                  @Param(value = "formatId") String formatId,
                                                  @Param(value = "contract") String contract) {

        return advertisingObjectRep.findAll((Specification<AdvertisingObjectEntity>) (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (aoTypeId != null) {
                predicates.add(cb.equal(root.get("ao_type_id"), Integer.getInteger(aoTypeId)));
            }
            if (cityId != null) {
                predicates.add(cb.equal(root.get("city_id"), Integer.getInteger(cityId)));
            }
            if (segmentId != null) {
                predicates.add(cb.equal(root.get("segment_id"), Integer.getInteger(segmentId)));
            }
            if (formatId != null) {
                predicates.add(cb.equal(root.get("format_id"), Integer.getInteger(formatId)));
            }
            if (reservation != null) {
                predicates.add(cb.equal(root.get("reservation_status"), Boolean.valueOf(reservation)));
            }
            if (contract != null) {
                if (contract.equals("true")) {
                    predicates.add(cb.isNotNull(root.get("contract")));
                } else {
                    predicates.add(cb.isNull(root.get("contract")));
                }
            }
            try {
                Predicate predicate = cb.and(predicates.toArray(new Predicate[predicates.size()]));
                return predicate;
            } catch (NoResultException nre) {
                return null;
            }
        });
    }
}
