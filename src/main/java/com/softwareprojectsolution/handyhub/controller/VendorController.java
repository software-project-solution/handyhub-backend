package com.softwareprojectsolution.handyhub.controller;

import com.softwareprojectsolution.handyhub.dto.VendorDto;
import com.softwareprojectsolution.handyhub.model.util.ResponseHandler;
import com.softwareprojectsolution.handyhub.service.VendorService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("api/v1/vendor")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @PostMapping(value = "/insertVendor")
    private ResponseEntity<Object> addVendor(@Valid @RequestBody VendorDto vendorDto) {

        ResponseEntity<Object> res = vendorService.insertVendorDetails(vendorDto);
        return ResponseHandler.generateResponse((HttpStatus) res.getStatusCode(), res.getBody());
    }
}
