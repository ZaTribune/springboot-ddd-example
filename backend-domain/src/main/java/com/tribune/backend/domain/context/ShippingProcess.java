package com.tribune.backend.domain.context;

import com.tribune.backend.domain.context.element.AggregateRoot;
import com.tribune.backend.domain.context.element.common.address.Address;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class ShippingProcess extends AggregateRoot<UUID> {
    private Long order;
    private Address address;
    private String note;
}
