package com.tribune.backend.domain.dto.order.lineitem;


import com.tribune.backend.domain.dto.order.Order;
import com.tribune.backend.domain.dto.order.lineitem.product.Product;
import lombok.*;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LineItem {

    private UUID id;

    private Order order;

    private Product product;
}
