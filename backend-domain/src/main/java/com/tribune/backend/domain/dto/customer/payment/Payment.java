package com.tribune.backend.domain.dto.customer.payment;


import com.tribune.backend.domain.LocalEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class Payment extends LocalEntity<UUID>{

    private String note;

    private UUID customerId;

}
