package com.vmp.server.controllers;

import com.vmp.server.entities.SegmentsEntity;
import com.vmp.server.repositories.SegmentsRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SegmentController {

    @Autowired
    SegmentsRep segmentsRep;

    @GetMapping("/segments")
    public List<SegmentsEntity> selectSegments() {
        return segmentsRep.findAllByOrderBySegment();
    }
}
