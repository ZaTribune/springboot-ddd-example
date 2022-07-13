package com.tribune.backend.infrastructure.db.entities;


import com.tribune.backend.domain.enums.OrderStatus;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class OrderEntity {

    @Id
    private UUID id;

    private OrderStatus status;

    @OneToMany
    private List<LineItemEntity> lineItemEntities;
}
