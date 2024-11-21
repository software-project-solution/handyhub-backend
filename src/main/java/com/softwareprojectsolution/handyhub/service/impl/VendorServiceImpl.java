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
            Optional<Vendor> existingVendor = Optional.ofNullable(vendorRepository.findVendorByFirstNameAndMobile(vendorDto.getFirstName(), vendorDto.getMobile()));

            Vendor vendor;

            if (existingVendor.isPresent()) {
                vendor = existingVendor.get();
                log.info("Updating existing vendor record with name: {} and mobile: {}", vendor.getFirstName(), vendorDto.getMobile());
            } else {
              vendor = new Vendor();
                log.info("Creating new vendor record with name: {} and mobile: {}", vendor.getFirstName(), vendorDto.getMobile());
            }

            vendor.setFirstName(vendorDto.getFirstName());
            vendor.setLastName(vendorDto.getLastName());
            vendor.setAddress(vendorDto.getAddress());
            vendor.setMobile(vendorDto.getMobile());
            vendorRepository.save(vendor);

            return ResponseHandler.generateResponse(HttpStatus.OK, "Successfully saved the vendor data");
        } catch (Exception e) {
            log.error("Exception message: {}", e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
