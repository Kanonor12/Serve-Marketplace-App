package com.coderkanono.marketplaceapp.services;

import com.coderkanono.marketplaceapp.model.ServiceModel;

import java.util.List;

public interface Service {
    ServiceModel createServiceProvider(ServiceModel serviceModel);

    List<ServiceModel> getAllServiceProviders();

    boolean deleteServiceProvider(String id);

    ServiceModel getServiceProviderById(String id);

    ServiceModel updateServiceProvider(String id, ServiceModel serviceModel);
}
