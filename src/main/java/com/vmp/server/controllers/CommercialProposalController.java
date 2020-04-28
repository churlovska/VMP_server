package com.vmp.server.controllers;

import com.vmp.server.response.AOResponse;
import com.vmp.server.response.CPResponse;
import com.vmp.server.service.CommercialProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommercialProposalController {

    @Autowired
    CommercialProposalService commercialProposalService;

    @PostMapping(path = "/cp")
    public ResponseEntity<Integer> createAo(@RequestBody CPResponse cpResponse) {

        System.out.println("POST comm_proposal");

        if (cpResponse != null) {
            boolean addedCP = commercialProposalService.createCP(-1, cpResponse);

            if (addedCP) {
                System.out.println("CP added");
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                System.out.println("CP not added");
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
