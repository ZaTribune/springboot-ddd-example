package com.tribune.backend.infrastructure.db.entities;


import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class LineItemEntity {

    @Id
    private UUID id;

    @ManyToOne
    private OrderEntity orderEntity;

    @OneToOne
    private ProductEntity productEntity;
}
