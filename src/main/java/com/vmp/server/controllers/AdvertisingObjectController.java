package com.vmp.server.controllers;

import com.vmp.server.entities.AdvertisingObjectEntity;
import com.vmp.server.repositories.AdvertisingObjectRep;
import com.vmp.server.request.AOResponse;
import com.vmp.server.service.AdvertisingObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NoResultException;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AdvertisingObjectController {

    @Autowired
    AdvertisingObjectRep advertisingObjectRep;

    @Autowired
    AdvertisingObjectService advertisingObjectService;

    @DeleteMapping("/ao/{id}")
    public ResponseEntity<Integer> deleteAO(@PathVariable Integer id) {

        boolean isRemoved = advertisingObjectService.deleteAO(id);

        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PostMapping(path = "/ao")
    public ResponseEntity<Integer> createAo(@RequestBody AOResponse aoResponse) {

        System.out.println("POST adv_object");

        if (aoResponse != null) {
            boolean addedAO = advertisingObjectService.createAO(-1, aoResponse);

            if (addedAO) {
                System.out.println("AO added");
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                System.out.println("AO not added");
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping(path = "/ao/{id}")
    public ResponseEntity<Integer> updateAo(@PathVariable Integer id, @RequestBody AOResponse aoResponse) {

        if (aoResponse != null) {
            boolean addedAO = advertisingObjectService.createAO(id, aoResponse);

            if (addedAO) {
                System.out.println("AO updated");
                return new ResponseEntity<>(id, HttpStatus.OK);
            } else {
                System.out.println("AO not updated");
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/ao")
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
                                                  @Param(value = "placementPossibility") String placementPossibility,
                                                  @Param(value = "segment1Id") String segmentId1,
                                                  @Param(value = "segment2Id") String segmentId2,
                                                  @Param(value = "segment3Id") String segmentId3) {
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
            if (segmentId1 != null) {
                predicates.add(cb.equal(root.get("subsegment1_id"), Integer.valueOf(segmentId1)));
            }
            if (segmentId2 != null) {
                predicates.add(cb.equal(root.get("subsegment2_id"), Integer.valueOf(segmentId2)));
            }
            if (segmentId3 != null) {
                predicates.add(cb.equal(root.get("subsegment3_id"), Integer.valueOf(segmentId3)));
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
