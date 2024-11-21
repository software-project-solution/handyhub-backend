package com.softwareprojectsolution.handyhub.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "vendor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vendor {
    @TableGenerator(name = "tbl", initialValue = 100, allocationSize = 1)
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator = "tbl")
    private Integer id;
    @NotBlank(message = "first name is mandatory")
    private String firstName;
    private String lastName;
    private String address;
    private String mobile;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
}
