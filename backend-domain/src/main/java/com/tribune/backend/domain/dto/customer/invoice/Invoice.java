package com.tribune.backend.domain.dto.customer.invoice;


import com.tribune.backend.domain.dto.customer.Customer;
import lombok.*;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Invoice {

    private UUID id;

    private Customer customer;
}
