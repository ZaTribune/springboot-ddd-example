package com.tribune.backend.domain.context.element.customer.invoice;


import com.tribune.backend.domain.context.element.customer.Customer;
import lombok.*;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Invoice {

    private Long id;

    private Customer customer;
}
