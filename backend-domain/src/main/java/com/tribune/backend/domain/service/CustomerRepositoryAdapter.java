package com.tribune.backend.domain.service;

import com.tribune.backend.domain.element.customer.Customer;

import java.util.List;
import java.util.UUID;

/**
 * Please note that adapter implementation should NOT contain any business logic.
 * All operations with Domain element should be initiated and encapsulated only in domain module
 */
public interface CustomerRepositoryAdapter {

    /**
     * Use Pagination to return a subset of the Customer collection
     * @param pageNumber - zero-based page index, must not be negative
     * @param pageSize - the size of the page to be returned, must be greater than 0
     * @return a subset of the Customer collection, otherwise an empty list
     */
    List<Customer> findAll(final int pageNumber, final int pageSize);


    Customer findByCustomerId(final UUID customerId);

    /**
     * Saves a customer in the persistence repository.
     *
     * @param customer the customer to save
     * @return the saved {@link Customer}
     */
    Customer save(Customer customer);
}
