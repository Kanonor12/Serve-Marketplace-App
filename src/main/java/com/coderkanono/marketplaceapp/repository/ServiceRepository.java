package com.coderkanono.marketplaceapp.repository;

import com.coderkanono.marketplaceapp.collection.ServiceProvider;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends MongoRepository<ServiceProvider<ServiceProvider>, String> {
}
