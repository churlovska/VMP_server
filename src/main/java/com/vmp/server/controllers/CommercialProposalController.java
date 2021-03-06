package com.vmp.server.controllers;

import com.vmp.server.entities.AdvertisingObjectEntity;
import com.vmp.server.entities.CommercialProposalEntity;
import com.vmp.server.repositories.AdvertisingObjectRep;
import com.vmp.server.repositories.CommercialProposalRep;
import com.vmp.server.response.*;
import com.vmp.server.service.CommercialProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @Autowired
    CommercialProposalRep commercialProposalRep;

    @PostMapping(path = "/cp")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public void createCP(@RequestBody CPRequest cpRequest, HttpServletResponse response) {

        System.out.println("POST comm_proposal");

        if (cpRequest != null) {
            boolean addedCP = commercialProposalService.createCP(-1, cpRequest);

            if (!addedCP) {
                System.out.println("CP not added");
                return;
            }

            System.out.println("CP added");

            String excelCreated = commercialProposalService.createExcel(cpRequest);

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
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> countCP(@RequestBody ArrayList<EstimateResponse> estimateResponses,
                                                         @PathVariable Double b1_price) {

        try {
            Double discount;
            for (EstimateResponse o : estimateResponses) {
                discount = Double.parseDouble(o.getDiscount().substring(0, o.getDiscount().indexOf('%'))) / 100.0;
                o.setDiscount_price(o.getPrice() * discount * (1 - o.getStrategic_discount() / 100.0));
                o.setFinal_price(o.getDiscount_price() * o.getAo_count() * o.getDuration());
            }
        }
        catch(NumberFormatException ex) {
            ex.printStackTrace();
            return new ResponseEntity<>("Wrong discount format", HttpStatus.BAD_REQUEST);
        }

        int ao_count_comm = 0;
        double price_comm = 0;
        int traffic_comm = 0;
        int ots_comm = 0;
        int coverage_comm = 0;
        double cpt_comm = 0;
        double placement_fin;
        double price_fin;
        double price_vat_fin;

        for (EstimateResponse o: estimateResponses) {
            ao_count_comm += o.getAo_count();
            price_comm += o.getFinal_price();
            traffic_comm += o.getVisits_traffic();
            ots_comm += o.getOts_contacts();
            coverage_comm += o.getCoverage_people();
            cpt_comm += o.getCpt();
        }

        estimateResponses.add(new EstimateResponse("Итого", ao_count_comm, price_comm, traffic_comm, ots_comm, coverage_comm, cpt_comm));

        placement_fin = price_comm*1.2;
        price_fin = placement_fin + b1_price;
        price_vat_fin = price_fin*1.2;

        EstimateCountResponse estimateCountResponse = new EstimateCountResponse(placement_fin, b1_price, price_fin, price_vat_fin, estimateResponses);

        return new ResponseEntity<>(estimateCountResponse, HttpStatus.OK);
    }

    @PostMapping(path = "/cp_form_estimate")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
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

    @GetMapping(path = "/cp")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<ArrayList<CPListResponse>> selectCPs() {

        ArrayList<CPListResponse> cpListResponses = new ArrayList<>();
        ArrayList<CommercialProposalEntity> commercialProposalEntities = commercialProposalRep.findByOrderByCreatingDateDesc();

        for (CommercialProposalEntity o: commercialProposalEntities) {
            cpListResponses.add(new CPListResponse(o.getId(), o.getName(), o.getClient(), o.getCreatingDate()));
        }
        return new ResponseEntity<>(cpListResponses, HttpStatus.OK);
    }

    @GetMapping(path = "/cp/{id}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<CPResponse> selectCPById(@PathVariable Integer id) {

        CPResponse cpResponse = commercialProposalService.selectCPById(id);
        return new ResponseEntity<>(cpResponse, HttpStatus.OK);
    }
}
