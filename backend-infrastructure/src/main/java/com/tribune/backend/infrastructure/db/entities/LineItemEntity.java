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
@Table(name ="LINE_ITEM")
public class LineItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "customer_order")
    private Long customerOrder;


    @JoinColumn(name = "product",referencedColumnName = "id")
    @ManyToOne
    private ProductEntity product;

    private Integer quantity;
}
