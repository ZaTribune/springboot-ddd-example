package com.tribune.backend.infrastructure.db.entities;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class PaymentEntity {
    @Id
    private UUID id;



    @ManyToOne
    @JoinColumn(name = "customer",referencedColumnName = "id")
    private CustomerEntity customerEntity;
}
