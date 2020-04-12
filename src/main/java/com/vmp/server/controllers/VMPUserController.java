package com.vmp.server.controllers;

import com.vmp.server.entities.*;
import com.vmp.server.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.NoResultException;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class VMPUserController {

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

    @Autowired
    MiSocSignRep miSocSignRep;

    @GetMapping("/")
    public String home(){
        return("Home page");
    }

    @GetMapping("/show_users")
    public List<VMPUserEntity> selectUsers() {
        return vmpUserRep.findByOrderByLastnameAscFirstnameAscLoginAsc();
    }

    @GetMapping("/ao_list_types")
    public List<MiTypesEntity> selectAOTypes() {
        return aoTypesRep.findAllOrOrderByType();
    }

    @GetMapping("/ao_list_cities")
    public List<CityEntity> selectCities() {
        return cityRep.findAllByOrderByCityAsc();
    }

    @GetMapping("/ao_list_segments")
    public List<SegmentsEntity> selectSegments() {
        return segmentsRep.findAllByOrderBySegment();
    }

    @GetMapping("/ao_list_formats")
    public List<FormatsEntity> selectFormats() {
        return formatsRep.findAllByOrderByFormat();
    }

    @GetMapping("/ao_list_significance")
    public List<MiSocSignEntity> selectSignificance() {
        return miSocSignRep.findAllByOrderBySignificance();
    }

    @GetMapping("/ao_list_result")
    public List<AdvertisingObjectEntity> selectAO(@Param(value = "miTypeId") String miTypeId,
                                                  @Param(value = "cityId") String cityId,
                                                  @Param(value = "reservation") String reservation,
                                                  @Param(value = "segmentId") String segmentId,
                                                  @Param(value = "formatId") String formatId,
                                                  @Param(value = "contract") String contract,
                                                  @Param(value = "floor") String floor,
                                                  @Param(value = "neighbors") String neighbors,
                                                  @Param(value = "pockets") String pockets,
                                                  @Param(value = "socSign") String socSign,
                                                  @Param(value = "placementPossibility") String placementPossibility) {
        return advertisingObjectRep.findAll((Specification<AdvertisingObjectEntity>) (root, query, cb) -> {

            List<Predicate> predicates = new ArrayList<>();
            if(placementPossibility != null) {
                predicates.add(cb.equal(root.get("possibility_of_placement"), Boolean.valueOf(placementPossibility)));
            }
            if (socSign != null) {
                predicates.add(cb.equal(root.get("mi_id"), Integer.valueOf(socSign)));
            }
            if (pockets != null) {
                predicates.add(cb.equal(root.get("pockets"), Integer.valueOf(pockets)));
            }
            if (floor != null) {
                predicates.add(cb.equal(root.get("floor"), Integer.valueOf(floor)));
            }
            if(neighbors != null) {
                predicates.add(cb.equal(root.get("neighbors"), Boolean.valueOf(neighbors)));
            }
            if (miTypeId != null) {
                predicates.add(cb.equal(root.get("mi_type_id"), Integer.valueOf(miTypeId)));
            }
            if (cityId != null) {
                predicates.add(cb.equal(root.get("city_id"), Integer.valueOf(cityId)));
            }
            if (segmentId != null) {
                predicates.add(cb.equal(root.get("segment_id"), Integer.valueOf(segmentId)));
            }
            if (formatId != null) {
                predicates.add(cb.equal(root.get("placing_format_id"), Integer.valueOf(formatId)));
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
