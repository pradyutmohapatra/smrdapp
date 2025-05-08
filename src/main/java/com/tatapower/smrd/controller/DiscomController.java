package com.tatapower.smrd.controller;
import com.tatapower.smrd.dto.DiscomRequest;
import com.tatapower.smrd.service.DiscomService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/discom")
public class DiscomController {
    private final DiscomService discomService;

    public DiscomController(DiscomService discomService) {
        this.discomService = discomService;
    }

    @PostMapping("/saveDiscom")
    public String saveDiscom(@RequestBody DiscomRequest discomRequest) {
        discomService.saveDiscom(discomRequest);
        return "success";
    }
}
