package com.tribune.backend.infrastructure.db.entities;


import com.tribune.backend.domain.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamicUpdate
@Entity
@Table(name = "CUSTOMER_ORDER")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Enumerated(value = EnumType.STRING)
    private OrderStatus status;

    @OneToMany(mappedBy = "id", fetch = FetchType.LAZY)
    private List<LineItemEntity> lineItems;


    private BigDecimal payment;

    @CreationTimestamp
    @Column(name = "CREATION_TIMESTAMP", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime creationTimestamp;

    @UpdateTimestamp
    @Column(name = "UPDATE_TIMESTAMP", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updateTimestamp;

    public OrderEntity(Long order) {
        this.id = order;
    }
}
