package com.vmp.server.controllers;

import com.vmp.server.entities.AdvertisingObjectEntity;
import com.vmp.server.repositories.AdvertisingObjectRep;
import com.vmp.server.response.*;
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
import java.util.HashMap;
import java.util.Map;

@RestController
public class CommercialProposalController {

    @Autowired
    CommercialProposalService commercialProposalService;

    @Autowired
    AdvertisingObjectRep advertisingObjectRep;

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
    public ResponseEntity<EstimateCountResponse> countCP(@RequestBody ArrayList<EstimateRequest> estimateRequests,
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

        for (EstimateRequest o: estimateRequests) {
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

    @PostMapping(path = "/cp_count_discount")
    public ResponseEntity<ArrayList<Double>> countCPDiscount(@RequestBody DiscountRequest discountRequest) {
        ArrayList<Double> response = new ArrayList<>();
        Double discPrice = discountRequest.getPrice()*(1-discountRequest.getDiscount())*(1-discountRequest.getStrDiscount());
        Double finPrice = discPrice*discountRequest.getAoCount()*discountRequest.getDuration();

        response.add(discPrice);
        response.add(finPrice);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(path = "/cp_form_estimate")
    public ResponseEntity<ArrayList<EstimateResponse>> fillEstimate (@RequestBody ArrayList<Integer> ids) {

        ArrayList<AdvertisingObjectEntity> advObjects = advertisingObjectRep.findByIdIn(ids);
        HashMap<String, Integer> countAO = new HashMap<>();

        for (AdvertisingObjectEntity o: advObjects) {
            if (countAO.containsKey(o.getCity().getCity())){
                countAO.put(o.getCity().getCity(), countAO.get(o.getCity().getCity()) + 1);
            } else{
                countAO.put(o.getCity().getCity(), 1);
            }
        }

        ArrayList<EstimateResponse> response = new ArrayList<>();

        int commonValue = 0;

        for(Map.Entry<String, Integer> entry: countAO.entrySet()) {
            response.add(new EstimateResponse(entry.getKey(), entry.getValue()));
            commonValue += entry.getValue();
        }

        response.add(new EstimateResponse("Итого", commonValue));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
