package com.tribune.backend.domain.dto;


import com.tribune.backend.domain.element.order.Order;
import com.tribune.backend.domain.element.order.lineitem.product.Product;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class SingleOrderResponse {

    private Order order;

    private BigDecimal totalCost;

    private List<Product> products;

}
