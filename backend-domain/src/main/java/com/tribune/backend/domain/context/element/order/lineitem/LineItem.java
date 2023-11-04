package com.tribune.backend.domain.context.element.order.lineitem;


import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LineItem {

    private Long id;

    private Long order;

    private Long product;

    private Integer quantity;
}
