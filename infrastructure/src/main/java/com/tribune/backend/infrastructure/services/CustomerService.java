package com.tribune.backend.infrastructure.services;

import com.tribune.backend.infrastructure.db.entities.CustomerEntity;

import java.util.UUID;

public interface CustomerService {

    CustomerEntity getCustomerById(UUID userId);
}
