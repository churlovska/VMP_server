package com.vmp.server.controllers;

import com.vmp.server.entities.MiTypesEntity;
import com.vmp.server.entities.SegmentsEntity;
import com.vmp.server.repositories.SegmentsRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SegmentController {

    @Autowired
    SegmentsRep segmentsRep;

    @GetMapping("/segments")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<SegmentsEntity> selectSegments() {
        return segmentsRep.findAllByOrderBySegment();
    }

    @PostMapping(path = "/segments")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public void addSegment(@RequestBody SegmentsEntity segmentsEntity) {
        if (segmentsEntity != null) {
            segmentsRep.save(segmentsEntity);
        }
    }

    @PutMapping("/segments/{id}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public void updateSegment(@RequestBody SegmentsEntity segmentsEntity, @PathVariable Integer id) {
        segmentsEntity.setId(id);
        segmentsRep.save(segmentsEntity);
    }

    @DeleteMapping("/segments/{id}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
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
