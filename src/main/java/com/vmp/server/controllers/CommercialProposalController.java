package com.vmp.server.controllers;

import com.vmp.server.response.CPResponse;
import com.vmp.server.service.CommercialProposalService;
import org.eclipse.jdt.internal.compiler.env.ISourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.ls.LSOutput;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class CommercialProposalController {

    @Autowired
    CommercialProposalService commercialProposalService;

    @PostMapping(path = "/cp")
    public void createAo(@RequestBody CPResponse cpResponse, HttpServletResponse response) {

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

                    System.out.println("File is sent");

                    try {
                        Files.copy(file, response.getOutputStream());
                        response.getOutputStream().flush();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }

            }
        }
    }
}
