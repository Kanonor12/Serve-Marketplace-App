package com.coderkanono.marketplaceapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceModel {
    private String serviceId;
    private String businessName;
    private String serviceCategory;
    private String city;
    private String address;
    private String description;
    private String telephone;
    private String email;
}
