package com.tribune.backend.domain.context.element.customer;


import com.tribune.backend.domain.context.element.Entity;
import com.tribune.backend.domain.context.element.common.address.Address;
import com.tribune.backend.domain.context.element.customer.payment.Payment;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class Customer extends Entity<Long> {

    private String displayName;

    private String firstName;

    private String lastName;

    private CustomerState state;

    private CustomerType type;

    //todo: like Address

    private List<Payment> paymentList;

    private List<Address> addressList;

    @Override
    public String toString() {

        return "Customer{" +
                "id=" + getId() +
                ", displayName='" + displayName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", state=" + state +
                ", type=" + type +
                ", paymentList=" + paymentList +
                ", addressList=" + addressList +
                '}';
    }

}
