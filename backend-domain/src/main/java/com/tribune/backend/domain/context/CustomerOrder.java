package com.tribune.backend.domain.context;

import com.tribune.backend.domain.AggregateRoot;
import com.tribune.backend.domain.dto.customer.Customer;
import com.tribune.backend.domain.dto.order.Order;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class CustomerOrder extends AggregateRoot<UUID> {


    private Customer customer;
    private Order order;
}
