package com.coderkanono.marketplaceapp.services;

import com.coderkanono.marketplaceapp.collection.ServiceProvider;
import com.coderkanono.marketplaceapp.model.ServiceModel;
import com.coderkanono.marketplaceapp.repository.ServiceRepository;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class ServiceImplementation implements Service{
    private ServiceRepository serviceRepository;

    public ServiceImplementation(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }
    @Override
    public ServiceModel createServiceProvider(ServiceModel serviceModel) {
      ServiceProvider serviceProvider = new ServiceProvider();

        BeanUtils.copyProperties(serviceModel, serviceProvider);
        serviceRepository.save(serviceProvider);
        return serviceModel;
    }

    @Override
    public List<ServiceModel> getAllServiceProviders() {
        List<ServiceProvider<ServiceProvider>> serviceProviders = serviceRepository.findAll();

        List<ServiceModel> serviceModels = serviceProviders.stream().map(serve ->
                new ServiceModel(
                        serve.getServiceId(),
                        serve.getBusinessName(),
                        serve.getServiceCategory(),
                        serve.getCity(),
                        serve.getAddress(),
                        serve.getDescription(),
                        serve.getTelephone(),
                        serve.getEmail())).collect(Collectors.toList());
        return serviceModels;
    }

    @Override
    public boolean deleteServiceProvider(String id) {
        ServiceProvider serviceProvider = serviceRepository.findById(id).get();
        serviceRepository.delete(serviceProvider);
        return true;
    }

    @Override
    public ServiceModel getServiceProviderById(String id) {
        ServiceProvider serviceProvider = serviceRepository.findById(id).get();
        ServiceModel serviceModel = new ServiceModel();
        BeanUtils.copyProperties(serviceProvider, serviceModel);
        return serviceModel;
    }

    @Override
    public ServiceModel updateServiceProvider(String id, ServiceModel serviceModel) {
        ServiceProvider serviceProvider = serviceRepository.findById(id).get();
        serviceProvider.setServiceId(serviceModel.getServiceId());
        serviceProvider.setBusinessName(serviceModel.getBusinessName());
        serviceProvider.setServiceCategory(serviceModel.getServiceCategory());
        serviceProvider.setCity(serviceModel.getCity());
        serviceProvider.setAddress(serviceModel.getAddress());
        serviceProvider.setDescription(serviceModel.getDescription());
        serviceProvider.setTelephone(serviceModel.getTelephone());
        serviceProvider.setEmail(serviceModel.getEmail());

        serviceRepository.save(serviceProvider);
        return serviceModel;
    }
}
