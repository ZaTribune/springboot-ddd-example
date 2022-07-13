package com.tribune.backend.domain.dto.customer;


import com.tribune.backend.domain.Entity;
import com.tribune.backend.domain.dto.customer.address.Address;
import com.tribune.backend.domain.dto.customer.payment.Payment;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class Customer extends Entity<UUID> {


    private UUID id;

    private String displayName;

    private String firstName;

    private String lastName;

    private CustomerState state;

    private CustomerType type;

    //todo: like Address
    private List<Payment> paymentList;

    private List<Address> addressList;
}
