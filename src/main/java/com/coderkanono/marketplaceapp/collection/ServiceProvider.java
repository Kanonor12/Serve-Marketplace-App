package com.coderkanono.marketplaceapp.collection;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Builder
@Document(collection = "person-provider")
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
public class ServiceProvider<M> {

    @Id
    private String serviceId;
    private String businessName;
    private String serviceCategory;
    private String city;
    private String address;
    private String description;
    private String telephone;
    private String email;


}

