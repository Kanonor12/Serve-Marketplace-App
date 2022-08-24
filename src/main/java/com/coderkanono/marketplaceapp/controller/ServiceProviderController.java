package com.coderkanono.marketplaceapp.controller;



import com.coderkanono.marketplaceapp.collection.ServiceProvider;
import com.coderkanono.marketplaceapp.model.ServiceModel;
import com.coderkanono.marketplaceapp.services.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class ServiceProviderController {
    private final Service service;

    public ServiceProviderController(Service service) {
        this.service = service;
    }

    @PostMapping("/serviceproviders")
    public ServiceModel createServiceProvider(@RequestBody ServiceModel serviceModel){
        return service.createServiceProvider(serviceModel);
    }

    @GetMapping("/serviceproviders")
    public List<ServiceModel> getAllServiceProviders(){
        return service.getAllServiceProviders();
    }

    @DeleteMapping("/serviceproviders/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteServiceProvider(@PathVariable String id){
        boolean deleted = false;
        deleted = service.deleteServiceProvider(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", deleted);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/serviceproviders/{id}")
    public ResponseEntity<ServiceModel> getServiceProviderById(@PathVariable String id){
        ServiceModel serviceModel = null;
        serviceModel = service.getServiceProviderById(id);
        return ResponseEntity.ok(serviceModel);
    }

    @PutMapping("/serviceproviders/{id}")
    public ResponseEntity<ServiceModel> updateServiceProvider(@PathVariable String id, @RequestBody ServiceModel serviceModel){

        serviceModel = service.updateServiceProvider(id, serviceModel);
        return ResponseEntity.ok(serviceModel);

    }
}
