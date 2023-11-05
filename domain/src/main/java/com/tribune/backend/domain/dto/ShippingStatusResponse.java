package com.tribune.backend.domain.dto;


import com.tribune.backend.domain.context.element.common.address.Address;
import com.tribune.backend.domain.context.element.order.Order;
import com.tribune.backend.domain.context.element.shipping.ShippingStatus;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ShippingStatusResponse {

    private Long order;

    private Address address;

    private ShippingStatus status;

}
