package com.tribune.backend.domain.dto.order;


import com.tribune.backend.domain.Entity;
import com.tribune.backend.domain.dto.order.lineitem.LineItem;
import com.tribune.backend.domain.enums.OrderStatus;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.UUID;

@Setter
@Getter
@SuperBuilder
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class Order extends Entity<UUID> {

    private UUID id;

    private OrderStatus status;

    private List<LineItem> lineItemEntities;
}
