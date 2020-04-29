package com.vmp.server.controllers;

import com.vmp.server.entities.MiTypesEntity;
import com.vmp.server.entities.SegmentsEntity;
import com.vmp.server.repositories.SegmentsRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SegmentController {

    @Autowired
    SegmentsRep segmentsRep;

    @GetMapping("/segments")
    public List<SegmentsEntity> selectSegments() {
        return segmentsRep.findAllByOrderBySegment();
    }

    @PostMapping(path = "/segments")
    public void addCity(@RequestBody SegmentsEntity segmentsEntity) {
        if (segmentsEntity != null) {
            segmentsRep.save(segmentsEntity);
        }
    }

    @PutMapping("/segments/{id}")
    public void updateSegment(@RequestBody SegmentsEntity segmentsEntity, @PathVariable Integer id) {
        segmentsEntity.setId(id);
        segmentsRep.save(segmentsEntity);
    }

    @DeleteMapping("/segments/{id}")
    public void deleteSegment(@PathVariable Integer id) {

        try {
            if (segmentsRep.existsById(id)) {
                segmentsRep.deleteById(id);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
