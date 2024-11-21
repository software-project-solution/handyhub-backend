package com.softwareprojectsolution.handyhub.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendorDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String address;
    private String mobile;
}
