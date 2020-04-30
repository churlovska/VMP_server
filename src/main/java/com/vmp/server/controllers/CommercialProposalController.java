package com.vmp.server.controllers;

import com.vmp.server.response.CPResponse;
import com.vmp.server.response.EstimateCountResponse;
import com.vmp.server.response.EstimateRequest;
import com.vmp.server.response.EstimateResponse;
import com.vmp.server.service.CommercialProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

@RestController
public class CommercialProposalController {

    @Autowired
    CommercialProposalService commercialProposalService;

    @PostMapping(path = "/cp")
    public void createCP(@RequestBody CPResponse cpResponse, HttpServletResponse response) {

        System.out.println("POST comm_proposal");

        if (cpResponse != null) {
            boolean addedCP = commercialProposalService.createCP(-1, cpResponse);

            if (!addedCP) {
                System.out.println("CP not added");
                //       return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                return;
            }

            System.out.println("CP added");

            String excelCreated = commercialProposalService.createExcel(cpResponse);

            if (excelCreated == null) {
                System.out.println("excel not added");
            } else {

                System.out.println("excel added");

                Path file = Paths.get(excelCreated);
                if (Files.exists(file)) {
                    response.setContentType("APPLICATION/OCTET-STREAM");
                    response.addHeader("Content-Disposition", "attachment; filename=" + excelCreated);

                    try {
                        Files.copy(file, response.getOutputStream());
                        response.getOutputStream().flush();
                        System.out.println("File is sent");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }

            }
        }
    }

    @PostMapping(path = "/cp_count/{b1_price}")
    public ResponseEntity<EstimateCountResponse> countCP(@RequestBody ArrayList<EstimateRequest> estimateResponse,
                                                         @PathVariable Double b1_price) {

        int ao_count_comm = 0;
        double price_comm = 0;
        int traffic_comm = 0;
        int ots_comm = 0;
        int coverage_comm = 0;
        double cpt_comm = 0;
        double placement_fin;
        double price_fin;
        double price_vat_fin;

        for (EstimateRequest o: estimateResponse) {
            ao_count_comm += o.getAo_count();
            price_comm += o.getFinal_price();
            traffic_comm += o.getVisits_traffic();
            ots_comm += o.getOts_contacts();
            coverage_comm += o.getCoverage_people();
            cpt_comm += o.getCpt();
        }

        placement_fin = price_comm*1.2;
        price_fin = placement_fin + b1_price;
        price_vat_fin = price_fin*1.2;

        EstimateCountResponse estimateCountResponse = new EstimateCountResponse(ao_count_comm, price_comm, traffic_comm, ots_comm,
                coverage_comm, cpt_comm, placement_fin, b1_price, price_fin, price_vat_fin);

        return new ResponseEntity<>(estimateCountResponse, HttpStatus.OK);
    }
}
