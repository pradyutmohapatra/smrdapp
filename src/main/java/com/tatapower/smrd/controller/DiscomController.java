package com.tatapower.smrd.controller;

import com.tatapower.smrd.dto.DiscomRequestDTO;
import com.tatapower.smrd.service.DiscomService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/discom")
public class DiscomController {

    private final DiscomService discomService;

    public DiscomController(DiscomService discomService) {
        this.discomService = discomService;
    }

    @PostMapping("/save")
    public String saveDiscom(DiscomRequestDTO discomRequestDTO) {
        discomService.saveDiscom(discomRequestDTO);
        return "success";
    }
}
