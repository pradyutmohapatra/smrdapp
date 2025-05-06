package com.tatapower.smrd.controller;

import com.tatapower.smrd.dto.AgencyRequest;
import com.tatapower.smrd.entity.Agency;
import com.tatapower.smrd.service.AgencyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agency")
public class AgencyController {

    private final AgencyService agencyService;

    @Autowired
    public AgencyController(AgencyService agencyService) {
        this.agencyService = agencyService;
    }
    @PostMapping("/saveAgency")
    public ResponseEntity<Agency> saveOrUpdateAgency(@Valid @RequestBody AgencyRequest request) {
        Agency savedAgency = agencyService.saveOrUpdateAgency(request);
        return ResponseEntity.ok(savedAgency);
    }


}
