package com.softwareprojectsolution.handyhub.service;

import com.softwareprojectsolution.handyhub.dto.VendorDto;
import org.springframework.http.ResponseEntity;

public interface VendorService {
    ResponseEntity<Object> insertVendorDetails(VendorDto vendorDto);

    ResponseEntity<Object> getVendorDetails(Integer id);

}
