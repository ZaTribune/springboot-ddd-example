package com.tribune.backend.infrastructure.db.entities;


import com.tribune.backend.domain.dto.customer.CustomerState;
import com.tribune.backend.domain.dto.customer.CustomerType;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class CustomerEntity {

    @Id
    private UUID id;

    private String displayName;

    private String firstName;

    private String lastName;

    @Enumerated(value = EnumType.STRING)
    private CustomerState state;

    @Enumerated(value = EnumType.STRING)
    private CustomerType type;

    @OneToMany(mappedBy = "customerEntity", fetch = FetchType.LAZY)
    private List<PaymentEntity> paymentEntityList;

    @OneToMany(mappedBy = "customerEntity", fetch = FetchType.LAZY)
    private List<AddressEntity> addressEntityList;
}
