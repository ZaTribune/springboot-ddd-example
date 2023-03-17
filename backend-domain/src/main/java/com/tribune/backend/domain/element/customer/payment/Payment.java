package com.tribune.backend.domain.element.customer.payment;


import com.tribune.backend.domain.element.LocalEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;



@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class Payment extends LocalEntity<Long>{

    private String note;

    private Long customerId;

}
