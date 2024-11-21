package com.softwareprojectsolution.handyhub.service.impl;

import com.softwareprojectsolution.handyhub.dto.VendorDto;
import com.softwareprojectsolution.handyhub.model.Vendor;
import com.softwareprojectsolution.handyhub.model.util.ResponseHandler;
import com.softwareprojectsolution.handyhub.repository.VendorRepository;
import com.softwareprojectsolution.handyhub.service.VendorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class VendorServiceImpl implements VendorService {

    @Autowired
    private VendorRepository vendorRepository;

    @Override
    public ResponseEntity<Object> insertVendorDetails(VendorDto vendorDto) {
        try {
            Vendor vendor = new Vendor();
            vendor.setFirstName(vendorDto.getFirstName());
            vendor.setLastName(vendorDto.getLastName());
            vendor.setAddress(vendorDto.getAddress());
            vendor.setMobile(vendorDto.getMobile());
            vendorRepository.save(vendor);

            return ResponseHandler.generateResponse(HttpStatus.OK, "Successfully created the vendor data");
        } catch (Exception e) {
            log.error("Ex. message: {}", e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Object> getVendorDetails(Integer id) {
        Optional<Vendor> optionalVendor = vendorRepository.findById(id);

        if (optionalVendor.isPresent()) {
            Vendor vendor = optionalVendor.get();
            log.info("Vendor found: {}", vendor);
            return ResponseEntity.ok(vendor);
        } else {
            log.warn("Vendor with ID {} not found", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vendor not found with ID: " + id);
        }
    }

}
