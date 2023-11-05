package com.tribune.backend.domain.context.element.order.lineitem.product;


import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    private Long id;

    private String name;

    private String company;

    private Integer quantity;

    private BigDecimal price;

}
