package com.tribune.backend.domain.element.order;


import com.tribune.backend.domain.element.Entity;
import com.tribune.backend.domain.element.order.lineitem.LineItem;
import com.tribune.backend.domain.enums.OrderStatus;
import lombok.*;
import lombok.experimental.SuperBuilder;

import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@ToString
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class Order extends Entity<Long> {

    private Long id;

    private OrderStatus status;

    @Size(min = 1)
    private List<LineItem> lineItems;

    private BigDecimal payment;
}
