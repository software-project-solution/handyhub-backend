package com.softwareprojectsolution.handyhub.repository;

import com.softwareprojectsolution.handyhub.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor, Integer> {

    Vendor findVendorByFirstNameAndMobile(String firstName, String mobile);
}
