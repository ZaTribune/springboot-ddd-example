package com.tribune.backend.infrastructure.mappers;


import com.tribune.backend.domain.context.element.customer.Customer;
import com.tribune.backend.infrastructure.db.entities.CustomerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer toCustomer(CustomerEntity entity);
    CustomerEntity toCustomerEntity(Customer customer);

}
